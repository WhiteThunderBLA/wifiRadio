import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.lang.Math.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.sound.sampled.*;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.Vector;
import java.util.Enumeration;
import java.io.*;
import javax.sound.sampled.*;
import java.awt.font.*;
import java.text.*;
import javax.sound.sampled.*;
import java.io.*;
import javax.sound.sampled.AudioSystem;


/**
*

@author Tim
glory to jesus
*/


public class Slider extends JFrame{


    
boolean a = true;
boolean torn;
public Slider(){
super("box");

JPanel out = new JPanel();

JSlider set = new JSlider(1, 179);


        
JFrame box = new JFrame();
JButton on = new JButton("Record");
JButton off = new JButton("Listen");
box.setDefaultCloseOperation(EXIT_ON_CLOSE);
GridLayout experimentLayout = new GridLayout(0,1);
box.setLayout(experimentLayout);
on.addActionListener(new MyAction());
off.addActionListener(new Wallabe());
set.setMajorTickSpacing(10);
 set.setMinorTickSpacing(5);

JLabel ATSTUMAS_COUNTER = new JLabel();
JLabel inoqiouse = new JLabel();
               


set.addChangeListener(new ChangeListener(){
public void stateChanged(ChangeEvent e){


JSlider set = (JSlider) e.getSource();
try{
            if (!set.getValueIsAdjusting()){
                System.out.println(set.getValue());
                adio creet = new adio();
                int coolness = set.getValue();
              String str = String.valueOf(coolness);
               ATSTUMAS_COUNTER.setText(str);
            tira radio = new tira();
            radio.dSlider(coolness);
    }        
}catch(NullPointerException b){
    System.out.println(b.getMessage());
    }




}});
 

        





        out.add(ATSTUMAS_COUNTER);

box.add(out);

out.add(on);
out.add(off);
out.add(inoqiouse);
out.add(set);
box.setSize(300,300);
box.setVisible(true);

}


private void setLookAndFeel() {
try{
UIManager.setLookAndFeel(
"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}catch(Exception exc){
System.err.println("could use system look and feel"
+ exc);
}

}

public static void main(String args[]){

Slider tylo = new Slider(); 
       

}}