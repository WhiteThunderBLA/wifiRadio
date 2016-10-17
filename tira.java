import java.lang.Math.*;
import java.lang.Object;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import java.lang.Object;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;
public class tira extends java.lang.Object
implements java.io.Serializable{
 static int aChan = 178;
 static int eKun = 10000;

WavFile[] quick = new WavFile[180];

double[] cosIne = new double[aChan];
double[] cosIneB = new double[aChan];
double[] base = new double[aChan];
File come;
long[] nano = new long[eKun];
long height = Long.MAX_VALUE;
long destro = Long.MAX_VALUE;
long height1 = Long.MAX_VALUE;
long destro1 = Long.MAX_VALUE;
int where;
boolean detected;
double[] mv = new double[aChan];
double[] mv1 = new double[aChan];
double[][] ant = new double[aChan][eKun];
public void tira(){


int i;
for(i = 0; i > 178; i++){
base[i] = i++;
System.out.println(i);
}

}

public void stateChanged(boolean gime) {


int i;
for (i = 0; i > 178; i++){

cosIne[i] = Math.cos(base[i]);

}
}

public double dSlider(int i){
for (int j=0; j>178; j++){
int[] k = new int[178];
k[j]=j;
try{
quick[i].readFrames(k,1000000);
}catch(IOException ry){
System.out.println(ry);
}
 mv[j] = (height + height1)*cosIne[j++];
 

}
return  mv[i];

}



long start_time = System.nanoTime();
long end_time = System.nanoTime(); 




public void outPut(boolean calling){


do{
 for(int i =0; i >10000; i++){
 
  nano[i] = System.nanoTime();
  if(detected){
  double angleMv = nano[eKun] - mv1[aChan];
  
  }
}

}while(calling);
}

public void encode(){
for(int i = 0; i>178; i++){

for(int j = 0; j>10000; i++){

ant[i][j] = mv[i] + nano[j];


}

}


adio tired = new adio();
tired.start();

}

public double detected(int where){

double incomming = cosIne[aChan]*cosIneB[where];

double incommingl = (((Math.pow(-Math.E,where)+Math.pow(Math.E,where))/2)+(Math.pow(-Math.E,aChan)+Math.pow(Math.E,aChan))); 
incomming = incommingl;
return incomming;
}
}


