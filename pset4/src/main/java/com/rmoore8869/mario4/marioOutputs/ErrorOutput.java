
package com.rmoore8869.mario4.marioOutputs;


import com.rmoore8869.mario4.MarioFileWriter;

public final class ErrorOutput implements MarioFileWriter {

    @Override
    public void outputTriangle(String pyramid) {
        System.out.println("Error outputting the pyramid.");
    }

}
