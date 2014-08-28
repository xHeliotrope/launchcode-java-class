package com.rmoore8869;


import com.rmoore8869.dao.Stop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] varArgs){
        myMetroLinkFinder();
    }

    private static void myMetroLinkFinder(){
        //ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //JDBCFactory myJDBCFactory = (JDBCFactory) context.getBean("myJDBCFactory");
        //myJDBCFactory.getNextMetro();
        SqliteJDBC mysql = new SqliteJDBC();
        JDBCFactory myJDBCFactory = new JDBCFactory(mysql);
        myJDBCFactory.getNextMetro();
    }

}
