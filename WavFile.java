import java.io.*;

public class WavFile{


public static void WavFile(File file, int numChannels, long numFrames, int validBits, long sampleRate) throws IOException{

 file = new File("something.wav");
 int chan;
 long num;
 long open;
  chan = numChannels;
 num = numFrames;
 validBits = 64;
 open = sampleRate;
      }
      public void openWavFile(File f){
      File u;
      u = f;
      }
      public int getChannels(){
      tira tira = new tira();
      int k = tira.aChan;
      return k;
      
      }
      public  int readFrames(int[] sampleBuffer, int numFramesToRead) throws IOException{
      sampleBuffer = new int[numFramesToRead];
      int l;
      for ( l = 0; numFramesToRead > l; l++){
      sampleBuffer[l] = l;
      
      } 
      return l;
      
      
      }

      }