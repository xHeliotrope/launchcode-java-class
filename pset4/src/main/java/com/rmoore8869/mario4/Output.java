package com.rmoore8869.mario4;


class Output {

    public Output(String name, MarioFileWriter newMFW, Pyramid outputPyramid) {

        System.out.println("This is " + name);
        newMFW.outputTriangle(outputPyramid.pyramid);
    }

}
