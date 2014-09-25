package com.xheliotrope;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.*;
import org.springframework.context.support.*;


public class StlMetroRunnerTest extends TestCase {
    protected MetroLinkDaoFactory mldf;

    protected void setUpMetroFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application");
        mldf = (MetroLinkDaoFactory) context.getBean("myMetroLinkDaoFactory");
    }

    @Test
    public void testFactoryNames() {
        setUpMetroFactory();
        char[] letters = "abcdefghijklmnopqrstuvwxABCDEFGHIJKLMNOPQRSTUVWX".toCharArray();
        for (int i = 0; i < letters.length; i++) {
            assertFalse(mldf.retrieveStopTimes(Character.toString(letters[i])).isEmpty());
        }

    }
}
