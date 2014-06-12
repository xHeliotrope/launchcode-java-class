package pset4.marioOutputs;

import pset4.MarioFileWriter;


public class OutputFactory {

    private OutputFactory() {
    }

    private static OutputFactory outputfactory;

    public static OutputFactory outFacInstance() {
        if (outputfactory == null) {
            outputfactory = new OutputFactory();
        }
        System.out.println("AND went through here");
        return outputfactory;
    }

    public MarioFileWriter toFile(String pyramid) {
        return new mToFile();
    }

    public MarioFileWriter toConsole(String pyramid) {
        return new mToConsole();
    }

    public MarioFileWriter errorOutput() {
        return new ErrorOutput();
    }

}
