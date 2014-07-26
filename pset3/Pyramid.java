
package pset3;

import static pset3.PyramidRun.promptUser;


public class Pyramid {

    protected String pyramid;

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
}
