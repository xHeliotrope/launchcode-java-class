
package javalearning.marioOutputs;

import java.io.*;
import javalearning.MarioFileWriter;


public class mToFile implements MarioFileWriter {

    @Override
    public void outputTriangle(String triangle){
       boolean a = true;
       while(a){
       try{
          BufferedReader br = 
                  new BufferedReader(new InputStreamReader(System.in));
          System.out.println("Please enter a valid filepath with filename.");
          String filepath = br.readLine();
          File textFile = new File(filepath);
          PrintWriter out = new PrintWriter(textFile);
          out.println(triangle);
          out.close();
          if(textFile.isFile() && textFile.canRead()){
              a=false;
            }
          }
          catch(IOException e){
          System.out.println("Sorry, filepath not valid");
            }
          }
        
        }
    }
