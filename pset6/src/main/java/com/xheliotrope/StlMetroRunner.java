package com.xheliotrope;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.*;
import java.util.List;
import com.xheliotrope.ListTools.*;

public class StlMetroRunner {
    private static Logger log = Logger.getLogger(StlMetroRunner.class.toString());

    public static void main(String[] varArgs) {
        startUp();
    }

    private static MetroLinkDaoFactory mldf;
    private static InputLibrary inputLibrary;
    private static List<Integer> myList;

    private static void startUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application");
        mldf = (MetroLinkDaoFactory) context.getBean("myMetroLinkDaoFactory");
        //mldf.takeAction();
        userOption();
    }

    private static void userOption() {
        try {
            String inputString = inputLibrary.getNumberString();
            switch (inputString) {
                case "1": {
                    mldf.printStopNames(nameStartsWith());
                    return;
                }
                case "2": {
                    String myLocation = inputLibrary.getCurrentLocation();
                    mldf.retrieveStopTimes(myLocation);
                    listCheckAndFix();
                    mldf.printNextMetro(myList);
                    return;
                }
                case "3": {
                    mldf.printStopNames(nameStartsWith());
                    String myLocation = inputLibrary.getCurrentLocation();
                    myList = mldf.retrieveStopTimes(myLocation);
                    listCheckAndFix();
                    mldf.printNextMetro(myList);
                    return;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
               closeBuffer();
            }
        }


    private static String nameStartsWith() throws IOException {
        return inputLibrary.getBeginningOfLocation();
    }

    private static void listCheckAndFix() {
        while (myList.isEmpty()) {
            System.out.println("Your stop may not exist or may not have any available stop times.");
            System.out.println("Try Again?");
            System.out.println("Enter 'yes' for yes, and 'no' for no");
            try {
                inputLibrary.userContinue();
                String newCurrentLocation = inputLibrary.getCurrentLocation();
                myList = mldf.retrieveStopTimes(newCurrentLocation);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeBuffer() {
        try {
            inputLibrary.closeInputBuffer();
        }catch(IOException e){}
    }
}
