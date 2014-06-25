package com.rmoore8869.mario4.marioOutputs;

import com.rmoore8869.mario4.MarioFileWriter;


public class OutputFactory {

    private OutputFactory() {
    }

    private static OutputFactory outputfactory;

    public static OutputFactory outFacInstance() {
        if (outputfactory == null) {
            outputfactory = new OutputFactory();
        }
        return outputfactory;
    }


    public MarioFileWriter toFile(String pyramid) {
        return new MToFile();
    }

    public MarioFileWriter toConsole(String pyramid) {
        return new MToConsole();
    }

    public MarioFileWriter errorOutput() {
        return new ErrorOutput();
    }

}
