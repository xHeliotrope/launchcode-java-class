package pset4;


/**
 * rmoore8869
 * 6/11/2014
 */
public class Output{

    public Output(String name, String Pyramid, MarioFileWriter newMFW) {

        System.out.println("This is " + name);
        newMFW.outputTriangle(Pyramid);
    }

}
