import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class MyAction implements ActionListener{

public void actionPerformed(ActionEvent ae){
boolean banquo;
try{

adio wail = new adio();
tira cryent = new tira();
if (banquo= true){

wail.music();
    System.out.println("microphone on");
 wail.start();
    
 banquo = false;
 
 }else{
 System.out.println("mircorphone off");
 wail.stopRecording();
 banquo=true;
}    

}catch(NullPointerException sad){
System.out.println(sad.getMessage());
}

}}
