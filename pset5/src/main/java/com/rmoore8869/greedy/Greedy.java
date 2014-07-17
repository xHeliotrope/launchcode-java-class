package com.rmoore8869.greedy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.Double.parseDouble;
/**
 * rmoore8869
 * 7/14/2014
 */
public class Greedy{

    public static void main(String[] varArgs) {
        if (varArgs.length > 0) {
            double commandLineChange = parseDouble(varArgs[0]);
            myCurrency(commandLineChange);
        }
    }

    private static void myCurrency(double userChange){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        CoinCalculator cc = (CoinCalculator) context.getBean("AmericanConverter");
        System.out.println(cc.createMessage(userChange));
    }
}
