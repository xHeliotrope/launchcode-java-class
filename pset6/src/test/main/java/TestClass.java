package main.java;

import com.rmoore8869.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class TestClass {

    void setUpMetroLinkDB(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("application.xml");

    }


}
