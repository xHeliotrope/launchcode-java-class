
package com.rmoore8869.mario4.marioOutputs;


import com.rmoore8869.mario4.MarioFileWriter;

public class ErrorOutput implements MarioFileWriter {

    public MarioFileWriter mfw;
    @Override
    public void outputTriangle(String pyramid) {
        System.out.println("Well, something went wrong with the "
                + "MarioFileWriter.");
    }

    @Override
    public void setMarioFileWriter(MarioFileWriter mfw) {
        this.mfw=mfw;
    }

    @Override
    public MarioFileWriter getMarioFileWriter() {
        return mfw;
    }

}
