package pset3.marioOutputs;

import pset3.MarioFileWriter;


public class OutputFactory {

    public static MarioFileWriter toFile(String pyramid) {
        return new mToFile();
    }

    public static MarioFileWriter toConsole(String pyramid) {
        return new mToConsole();
    }

    public static MarioFileWriter errorOutput() {
        return new ErrorOutput();
    }

}
