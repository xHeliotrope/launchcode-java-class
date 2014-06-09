
package javalearning;

import java.io.*;
import javalearning.marioOutputs.*;
import static java.lang.Integer.parseInt;


public class Triangle {
    
    public static String triangle;

    public Triangle(){
        stepBuilder(inputReader());
        MarioFileWriter mfw = promptUser();
        mfw.outputTriangle(triangle);
        }
    
    public static int inputReader(){
        int inputInt = -1;
        String preInt;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean a = true;
        while(a){
            System.out.println("Please enter an integer between 0 and "
                    + "23(inclusive).");
            try{
            preInt = br.readLine();
            inputInt = parseInt(preInt);
               }
            catch(NumberFormatException | IOException e){
                System.out.println("Errrr...Does not compute.");
                }
            if(inputInt >=0 && inputInt <= 23){
                a=false;
            }
            }
    return inputInt;
    }
    
    public static void stepBuilder(int input){
       StringBuilder sb = new StringBuilder();
       String newline = System.getProperty("line.separator");
       for(int i=0; i<=input; i++){
           int j = i;
           int k = i;
           while(input-j!=0){
               sb.append(" ");
               j++;
               }           
           while(k>0){
               sb.append("#");
               k--;
               }
           sb.append(newline);
           triangle = sb.toString();
           }
           }
    
    public MarioFileWriter promptUser(){
            boolean temp = true;
            while(temp){
            String input = new String();
            String def1 = "Console", def2 = "File";
            System.out.println("Do you want your Mario Pyramid in a file"
                    + " or on the console?");
            System.out.println("Enter 'Console' for Console");
            System.out.println("Or, Enter 'File' for Text File");
            BufferedReader br = new BufferedReader
            (new InputStreamReader(System.in));
            try{
                input = br.readLine();
                }
            catch(IOException e){
                ErrorOutput eo1 = new ErrorOutput();
                return eo1;
                }
              if(input.equalsIgnoreCase(def1)){
                 mToConsole mtc = new mToConsole();
                 return mtc;
                 }
              else if(input.equalsIgnoreCase(def2)){
                 mToFile mtf = new mToFile();
                 return mtf;
                 }
              else{
                 System.out.println("Does not compute");
                  }
                }
        ErrorOutput eo2 = new ErrorOutput();    
        return eo2;
            }    
    
    public static void main(String[] args){
        Triangle tr = new Triangle();
        }
}
