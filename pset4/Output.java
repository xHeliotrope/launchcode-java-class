package pset4;


/**
 * rmoore8869
 * 6/11/2014
 */
public class Output extends Pyramid {

    public Output(String name, MarioFileWriter newMFW) {

        System.out.println("This is " + name);
        newMFW.outputTriangle(pyramid);
    }

}
