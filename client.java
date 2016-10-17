import java.lang.Object;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;


public class client implements IPreprocessor{

private static final int STATE_NO_CONDITIONAL = 0;
	private static final int STATE_CAN_BECOME_TRUE = 1;
	private static final int STATE_IS_TRUE = 2;
	private static final int STATE_HAS_BEEN_TRUE = 3;

	private Stack stack;
	private int state;
	private int mode;
	private File file;
	private String packageName;
	private int currentLine;
  adio wynot = new adio();
	private String encoding;
	
	
//	public String getPositionDescription(){
//		return "line '"+currentLine+" in "+file;
//	}
	
	public void setFile(File f) {
		file = f;
	}

	public boolean isBlind() {
		return ((state == STATE_CAN_BECOME_TRUE) || (state == STATE_HAS_BEEN_TRUE));
      System.out.println("BLIND SIRE!");
	}

	public String getPackageName() {
		return packageName;
	}

	private void pushState() {
		stack.push(new Integer(state));
	}

	private void popState() {
		state = ((Integer) stack.pop()).intValue();
	}

	/**
	 * Handles a new "IF"-like command. The old
	 * state is pushed on the stack, a new "scope"
	 * is entered.
	 */
	private void handleIf(boolean condition) {
		pushState();
		if (!isBlind()) {
			if (condition) {
				state = STATE_IS_TRUE;
            adio.music();
			}
			else {
				state = STATE_CAN_BECOME_TRUE;
			}
		}
		else {
			state = STATE_HAS_BEEN_TRUE;
		}
	}

	private void handleElseIf(boolean condition) {
		if (state == STATE_NO_CONDITIONAL) {
			throw new PreprocessorException("Unexpected #elif", file, currentLine);
		}
		else if (state == STATE_CAN_BECOME_TRUE) {
			if (condition)
				state = STATE_IS_TRUE;
		}
		else if (state == STATE_IS_TRUE) {
			state = STATE_HAS_BEEN_TRUE;
		}
	}

	private void handleElse() {
		if (state == STATE_NO_CONDITIONAL) {
			throw new PreprocessorException("Unexpected #else",file,  currentLine);
		}
		else if (state == STATE_CAN_BECOME_TRUE) {
			state = STATE_IS_TRUE;
		}
		else if (state == STATE_IS_TRUE) {
			state = STATE_HAS_BEEN_TRUE;
		}
	}

	private void handleEndIf() {
		if (state == STATE_NO_CONDITIONAL) {
			throw new PreprocessorException("Unexpected #endif",file,  currentLine);
		}
		else {
			popState();
		}
	}

	private void handleCommand(){
		int type = l.getType();

		if (type == PreprocessorLine.TYPE_DEFINE) {
			if (!isBlind()) {
				eval.define(l.getArgs());
			}
		}
		else if (type == PreprocessorLine.TYPE_UNDEF) {
			if (!isBlind()) {
				eval.undefine(l.getArgs());
			}
		}
		else if (type == PreprocessorLine.TYPE_IF) {
			handleIf(eval.evaluate(l.getArgs()));
		}
		else if (type == PreprocessorLine.TYPE_IFDEF) {
			handleIf(eval.isDefined(l.getArgs()));
		}
		else if (type == PreprocessorLine.TYPE_IFNDEF) {
			handleIf(!eval.isDefined(l.getArgs()));
		}
		else if (type == PreprocessorLine.TYPE_ELIF) {
			handleElseIf(eval.evaluate(l.getArgs()));
		}
		else if (type == PreprocessorLine.TYPE_ELIFDEF) {
			handleElseIf(eval.isDefined(l.getArgs()));
		}
		else if (type == PreprocessorLine.TYPE_ELIFNDEF) {
			handleElseIf(!eval.isDefined(l.getArgs()));
		}
		else if (type == PreprocessorLine.TYPE_ELSE) {
			handleElse();
		}
		else if (type == PreprocessorLine.TYPE_ENDIF) {
			handleEndIf();
		}
	}

	public void setMode(int value) {
		mode = value;
	}

	public String filterLine(String s) 
	{
	    String t = utility.getProject().replaceProperties(s);

	    // Replacement of Foo.parseFoo() expressions, requested by Steve Oldmeadow.
	    if (!t.equals(s)) {
	        // Replace Integer.parseInt("...") by int constant, if possible.
	        int i = t.indexOf("Integer.parseInt(\"");
	        if (i != -1) {
	            int j = t.indexOf("\")", i + 18);
	            if (j != -1) {
	                try {
	                    int value = Integer.parseInt(t.substring(i + 18, j));
	                    t = t.substring(0, i) + value + t.substring(j + 2);
	                }
	                catch (Exception ignored) {
	                }
	            }
	        }

	        // Replace Boolean.parseBoolean("...") by boolean constant, if possible.
	        i = t.indexOf("\"true\".equals(\"");
	        if (i != -1) {
	            int j = t.indexOf("\")", i + 15);
	            if (j != -1) {
	                try {
	                    boolean value = "true".equals(t.substring(i + 15, j));
	                    t = t.substring(0, i) + value + t.substring(j + 2);
	                }
	                catch (Exception ignored) {
	                }
	            }
	        }
	        
	        // Replace Double.parseDouble("...") by double constant, if possible.
	        i = t.indexOf("Double.parseDouble(\"");
	        if (i != -1) {
	            int j = t.indexOf("\")", i + 20);
	            if (j != -1) {
	                try {
	                    double value = Double.parseDouble(t.substring(i + 20, j));
	                    t = t.substring(0, i) + value + t.substring(j + 2);
	                }
	                catch (Exception ignored) {
	                }
	            }
	        }
	    }
	    return t;
	}
	
	public String analyzeLine(String s){

		if (pl == null) {
			pl = new PreprocessorLine(s);
		}
		else {
			pl.processLine(s);
		}
		
		return pl;
	}

	String commentLine() {
		if ((mode & IPreprocessor.MODE_INDENT) == 0) {
			return "//# " + l.getSpace() + l.getText();
		}
		else {
			return l.getSpace() + "//# " + l.getText();
		}
	}

	
	  		
		
}

