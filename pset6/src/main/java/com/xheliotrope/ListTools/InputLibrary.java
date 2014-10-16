package com.xheliotrope.ListTools;

import org.apache.log4j.Logger;

import java.io.*;

public final class InputLibrary {
    private static Logger log = Logger.getLogger(InputLibrary.class.toString());

    private static BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
    private static String stringInput;

    public static String getNumberString() throws IOException {
        System.out.println("Do you want a list of the Stops, to find the next coming metro/bus, or both?");
        System.out.println("Enter 1 for list");
        System.out.println("Enter 2 for next bus");
        System.out.println("Enter 3 for both");
        while (true) {
            stringInput = inputStream.readLine();
            if (stringInput.matches("^[1-3]$")) {
                return stringInput;
            }
            System.out.println("Please enter '1' '2' or '3'");
        }
    }

    public static String getBeginningOfLocation() throws IOException {
        while (true) {
            System.out.println("Please enter a single alphanumeric character[a-Z or 0-9].");
            stringInput = inputStream.readLine();
            if (stringInput.matches("^[A-Za-z0-9]$")) {
                return stringInput;
            }
        }
    }

    public static String getCurrentLocation() throws IOException {
        System.out.println("\nPlease enter the name of your current stop.");
        System.out.println("Most stops use the format: ");
        System.out.println("STATION A @ REGULAR RD \n");
        String myString = inputStream.readLine();
        return myString;
    }

    public static void userContinue() throws IOException{
        while(true) {
            try {
                stringInput = inputStream.readLine();
                if (stringInput.equalsIgnoreCase("yes")) {
                    return;
                } else if (stringInput.equalsIgnoreCase("no")) {
                    System.exit(0);
                }
            }
                catch(IOException e){
                    e.printStackTrace();
                }
                System.out.println("Could not understand your response, please type 'yes' or 'no'");
            }
        }

    public static void closeInputBuffer() throws IOException {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
