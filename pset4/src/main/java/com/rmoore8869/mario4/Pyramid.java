
package com.rmoore8869.mario4;

import com.rmoore8869.mario4.marioOutputs.*;

import static com.rmoore8869.mario4.PyramidRun.promptUser;


public class Pyramid {

    protected String pyramid;
    protected OutputFactory opFac1;

    public Pyramid(int pyrSteps) {
        pyramidMaker(pyrSteps);
    }

    private void pyramidMaker(int pyrSteps) {
        stepBuilder(pyrSteps);
        MarioFileWriter mfw = promptUser();
        mfw.outputTriangle(pyramid);
    }

    private void stepBuilder(int input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= input; i++) {
            int j = i;
            int k = i;
            while (input - j != 0) {
                sb.append(" ");
                j++;
            }
            while (k > 0) {
                sb.append("#");
                k--;
            }
            sb.append(System.getProperty("line.separator"));
            pyramid = sb.toString();
        }
    }

    public void fullPyramidOutput(Pyramid outputPyramid) {
        new Output("to the Console", opFac1.toConsole(pyramid), outputPyramid);
        new Output("to the error", opFac1.errorOutput(), outputPyramid);
        new Output("to a File", opFac1.toFile(pyramid), outputPyramid);
    }

}
