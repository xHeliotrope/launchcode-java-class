
package pset3;

import pset3.marioOutputs.*;

import static java.lang.Integer.parseInt;

import java.io.*;


public class PyramidRun {

    public static int inputReader() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Please enter an integer between 0 and "
                    + "23(inclusive).");
            try {
                int inputInt = (parseInt(br.readLine()));
                if (inputInt >= 0 && inputInt <= 23) {
                    return inputInt;
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Errrr...Does not compute.");
            }
        }
    }

    public static MarioFileWriter promptUser() {
        while (true) {
            String def1 = "Console", def2 = "File";
            System.out.println("Do you want your Mario Pyramid in a file"
                    + " or on the console?");
            System.out.println("Enter 'Console' for Console");
            System.out.println("Or, Enter 'File' for Text File");
            BufferedReader br = new BufferedReader
                    (new InputStreamReader(System.in));
            try {
                String input = br.readLine();
                if (input.equalsIgnoreCase(def1)) {
                    return new MToConsole();
                } else if (input.equalsIgnoreCase(def2)) {
                    return new MToFile();
                } else {
                    System.out.println("Does not compute.");
                }
            } catch (IOException e) {
                return new ErrorOutput();
            }
        }
    }


    public static void main(String[] varArgs) {
        Pyramid newP1 = new Pyramid(inputReader());
        new Output("to the Console", OutputFactory.outFacInstance().toConsole(newP1.pyramid), newP1);
        new Output("from user choice", promptUser(), newP1);
        new Pyramid(2);
    }

}