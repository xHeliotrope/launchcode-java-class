package com.rmoore8869.mario4;


class Output {
    private Output output;
    public Output(String name, MarioFileWriter newMFW, Pyramid outputPyramid) {

        System.out.println("This is " + name);
        newMFW.outputTriangle(outputPyramid.pyramidVisual);
    }

    public void setOutput(Output output){
        output=this.output;
    }
    public Output getOutput(){
        return output;
    }
}
