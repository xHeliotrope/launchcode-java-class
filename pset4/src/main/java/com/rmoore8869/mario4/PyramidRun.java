package com.rmoore8869.mario4;

import com.rmoore8869.mario4.marioOutputs.*;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.*;

import static java.lang.Integer.parseInt;

/**
 * rmoore8869
 * 6/23/2014
 */
public class PyramidRun {

    public static void main(String[] varArgs) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    PyramidRun obj = (PyramidRun) context.getBean("marioPyr1");
    }

    private static OutputFactory outputfactory = OutputFactory.outFacInstance();

    private static int inputReader() {
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

    static MarioFileWriter promptUser() {
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

    public PyramidRun(OutputFactory outputfactory) {
        Pyramid newP1 = new Pyramid(inputReader());
        Pyramid newP2 = new Pyramid(inputReader());
        new Output("to the Console", outputfactory.toConsole(newP1.pyramid), newP1);
        new Output("from user choice", promptUser(), newP2);
    }

}
