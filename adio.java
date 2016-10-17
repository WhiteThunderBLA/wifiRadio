import javax.sound.sampled.*;
import java.io.*;

import javax.sound.sampled.*;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import sun.audio.*;
import java.io.*;
import java.io.*;
public class adio{
String augustEnding;
TargetDataLine line;
AudioFormat format = getAudioFormat();
AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
File wavFile = new File("something.wav");
AudioInputStream ais = new AudioInputStream(line);
public void music(){



  try {
  
   WavFile cute = new WavFile();
   cute.WavFile(wavFile, 180, 1600, 64, 1);
   Clip clip = AudioSystem.getClip();

   clip.open(AudioSystem.getAudioInputStream(wavFile));
   clip.start();
   Thread.sleep(clip.getMicrosecondLength());
  } catch (Exception e) {
   System.err.println(e.getMessage());
  }
 }
 
public void stopMusic(){
try{
Clip clip = AudioSystem.getClip();
clip.close();
clip.stop();
}catch(Exception q){
System.out.println(q);
}
}
 // these two routines convert a byte array to a unsigned short
public static int byteArrayToInt(byte[] b)
{
  int start = 0;
  int low = b[start] & 0xff;
  int high = b[start+1] & 0xff;
  return (int)( high << 8 | low );
}
// these two routines convert a byte array to an unsigned integer
public static long byteArrayToLong(byte[] b)
{
  int start = 0;
  int i = 0;
  int len = 4;
  int cnt = 0;
  byte[] tmp = new byte[len];
  for (i = start; i < (start + len); i++)
  {
    tmp[cnt] = b[i];
    cnt++;
  }
  long accum = 0;
  i = 0;
  for ( int shiftBy = 0; shiftBy < 32; shiftBy += 8 )
  {
    accum |= ( (long)( tmp[i] & 0xff ) ) << shiftBy;
    i++;
  }
  return accum;
}
// returns a byte array of length 4
private static byte[] intToByteArray(int i)
{
  byte[] b = new byte[4];
  b[0] = (byte) (i & 0x00FF);
  b[1] = (byte) ((i >> 8) & 0x000000FF);
  b[2] = (byte) ((i >> 16) & 0x000000FF);
  b[3] = (byte) ((i >> 24) & 0x000000FF);
  return b;
}
// convert a short to a byte array
public static byte[] shortToByteArray(short data)
{
  return new byte[]{(byte)(data & 0xff),(byte)((data >>> 8) & 0xff)};
}

AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 180;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }

void start() {
        try {
            
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
 
            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // start capturing
 
            System.out.println("Start capturing...");
 
            AudioInputStream ais = new AudioInputStream(line);
 
            System.out.println("Start recording...");
 
            // start recording
            AudioSystem.write(ais, fileType, wavFile);
 
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
    }
    
    
    void stopRecording(){
    try{
    line.stop();
   ais.close();
    line.close();
    System.out.println("Recording Off");
    }catch(IOException quando){
    System.out.println(quando.getMessage());
    
    }
    }
    public static void deleteFile(String file){
    File myFile = new File(file);

    if (!myFile.delete()){
     System.out.println("Deletion was not sucessful");
    }else{
      System.out.println("File deleted");
    }
  } 
    /**
     * Closes the target data line to finish capturing and recording
     */
public void read(byte[] b, int off, int len){
len = intToByteArray();
b = byteArrayToInt();
off = 16000;
}
}