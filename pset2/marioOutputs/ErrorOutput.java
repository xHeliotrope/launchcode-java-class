
package javalearning.marioOutputs;

import javalearning.MarioFileWriter;


public class ErrorOutput implements MarioFileWriter{
    
    @Override
    public void outputTriangle(String triangle){
        System.out.println("Well, something went wrong with the "
                + "MarioFileWriter.");
        }
        }
