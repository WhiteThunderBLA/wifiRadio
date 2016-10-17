import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Wallabe implements ActionListener{
public void actionPerformed(ActionEvent ae){
try{

adio tyfo = new adio();
boolean set;
if(set=true){
set= false;
tyfo.music();
tira tylong = new tira();
     System.out.println("Listen");
     tylong.read();
     }else{
     set=true;
     
     tyfo.stopRecording();
     
}
}catch(NullPointerException npr){
System.out.println(npr.getMessage());

}
}
}