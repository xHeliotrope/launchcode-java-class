package pset3;


public class Output {

    public Output(String name, MarioFileWriter newMFW, Pyramid outputPyramid) {
        System.out.println("This is " + name);
        newMFW.outputTriangle(outputPyramid.pyramid);
    }

}
