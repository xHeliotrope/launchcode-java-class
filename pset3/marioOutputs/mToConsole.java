
package pset3.marioOutputs;

import pset3.MarioFileWriter;

public class mToConsole implements MarioFileWriter {

    @Override
    public void outputTriangle(String pyramid) {

        System.out.println(pyramid);
    }
}
