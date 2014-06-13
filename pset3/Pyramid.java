
package pset3;

import java.io.*;
import pset3.marioOutputs.*;
import static java.lang.Integer.parseInt;

public class Pyramid {

    public static String pyramid;
    private static Output output;

    public Pyramid(Output output){
        this.output = output;
        System.out.println("AAAAND went through here");
    }

    public static void pyramidMaker() {
        stepBuilder(inputReader());
        MarioFileWriter mfw = promptUser();
        mfw.outputTriangle(pyramid);
    }

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

    public static void stepBuilder(int input) {
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
                    return new mToConsole();
                } else if (input.equalsIgnoreCase(def2)) {
                    return new mToFile();
                } else {
                    System.out.println("Does not compute.");
                }
            } catch (IOException e) {
                return new ErrorOutput();
            }
        }
    }

    public static void main(String[] args) {
        pyramidMaker();
        new Output("to the Console", OutputFactory.outFacInstance().toConsole(pyramid));
        new Output("to a File", OutputFactory.outFacInstance().toFile(pyramid));

    }
}
