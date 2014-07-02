
package com.rmoore8869.mario4.marioOutputs;

import com.rmoore8869.mario4.MarioFileWriter;

public class MToConsole implements MarioFileWriter {

    public String pyramidOutput;
    public MarioFileWriter mfw;
    @Override
    public void outputTriangle(String pyramidOutput) {
        System.out.println(pyramidOutput);
    }

    @Override
    public void setMarioFileWriter(MarioFileWriter mfw) {
        this.mfw = mfw;
    }

    @Override
    public MarioFileWriter getMarioFileWriter() {
        return mfw;
    }

    public void setPyramidOutput(String pyramidOutput){
        this.pyramidOutput=pyramidOutput;
    }

    public String getPyramidOutput(){
        return pyramidOutput;
    }
}
