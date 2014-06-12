
package pset4.marioOutputs;

import pset4.MarioFileWriter;

public class mToConsole implements MarioFileWriter {

    @Override
    public void outputTriangle(String pyramid) {

        System.out.println(pyramid);
    }
}
