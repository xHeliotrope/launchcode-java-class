
package pset3.marioOutputs;

import pset3.MarioFileWriter;


public class MToConsole implements MarioFileWriter {

    @Override
    public void outputTriangle(String pyramid) {

        System.out.println(pyramid);
    }
}
