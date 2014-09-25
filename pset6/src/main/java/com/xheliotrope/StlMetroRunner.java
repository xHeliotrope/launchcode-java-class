package com.xheliotrope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.*;
import java.util.List;

public class StlMetroRunner {

    public static void main(String[] varArgs){
        startUp();
    }

    private static MetroLinkDaoFactory mldf;

    private static void startUp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application");
        mldf = (MetroLinkDaoFactory) context.getBean("myMetroLinkDaoFactory");
        userOption();
    }

    public static void userOption() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Do you want a list of the Stops, to find the next coming metro/bus, or both?");
            System.out.println("Enter 1 for list");
            System.out.println("Enter 2 for next bus");
            System.out.println("Enter 3 for both");
            try{
                String inputString = input.readLine();
                if (inputString.equals("1")) {
                    mldf.printStopNames(nameStartsWith());
                    return;
                }
                if (inputString.equals("2")) {
                    List<Integer> myList = mldf.retrieveStopTimes(currentLocation());
                    while(myList.isEmpty()) {
                        myList = listFix(input, myList);
                    }
                    mldf.printNextMetro(myList);
                    return;
                }
                if (inputString.equals("3")) {
                    mldf.printStopNames(nameStartsWith());
                    List<Integer> myList = mldf.retrieveStopTimes(currentLocation());
                    while(myList.isEmpty()) {
                        myList = listFix(input, myList);
                    }
                    mldf.printNextMetro(myList);
                    return;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public static String currentLocation(){
        System.out.println("Please enter the name of your current stop.");
        System.out.println("Most stops use the format: ");
        System.out.println("STATION A @ REGULAR RD \n");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            String inputString = input.readLine();
            return inputString.toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException();
    }

    public static String nameStartsWith() {
        while (true) {
            System.out.println("Please enter the first letter of the name of the stop you are looking for.");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            try{
                String inputString = input.readLine();
                if(inputString.matches("^[A-Za-z0-9]$")) {
                    return inputString;
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static List<Integer> listFix(BufferedReader br, List<Integer> myList){
        while(myList.isEmpty()){
            System.out.println("Your stop may not exist or may not have any available stop times.");
            System.out.println("Try Again?");
            System.out.println("Enter 'yes' for yes, and 'no' for no");
            try {
                String userResponse = br.readLine();
                if (userResponse.equalsIgnoreCase("yes")) {
                    String test = currentLocation();
                    myList = mldf.retrieveStopTimes(test);
                    return myList;
                } else if (userResponse.equalsIgnoreCase("no")) {
                    System.exit(0);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        throw new IllegalStateException();
    }
}
