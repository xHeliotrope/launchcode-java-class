
package com.rmoore8869.mario4.marioOutputs;

import com.rmoore8869.mario4.MarioFileWriter;

public class MToConsole implements MarioFileWriter {

    @Override
    public void outputTriangle(String pyramid) {

        System.out.println(pyramid);
    }
}
