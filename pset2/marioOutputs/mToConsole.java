
package pset2.marioOutputs;

import pset2.MarioFileWriter;

public class mToConsole implements MarioFileWriter {

    @Override
    public void outputTriangle(String pyramid) {

        System.out.println(pyramid);
    }
}
