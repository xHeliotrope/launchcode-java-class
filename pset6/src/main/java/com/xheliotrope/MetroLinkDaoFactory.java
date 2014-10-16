package com.xheliotrope;

import com.xheliotrope.ListTools.*;
import org.apache.log4j.Logger;

import java.util.*;

public class MetroLinkDaoFactory {
    private static Logger log = Logger.getLogger(MetroLinkDaoFactory.class.toString());
    private TimeCalculator timeCalculator;
    private ListConverter listConverter;

    public MetroLinkDaoFactory(TimeCalculator timeCalculator, ListConverter listConverter){
        this.timeCalculator = timeCalculator;
        this.listConverter = listConverter;
    }

    public void printStopNames(String nameStartsWith){
        TreeSet<String> nameSet = listConverter.getNameSet(nameStartsWith);
        print(nameSet);
    }
    public Set<String> retrieveStopNames(String nameStartsWith){
        return listConverter.getNameSet(nameStartsWith);
    }

    public List<Integer> retrieveStopTimes(String stopName){
        return listConverter.getStopTimes(stopName);
    }

    public void printNextMetro(List<Integer> stopTimes){
        int waitTime = timeCalculator.nextMetro(stopTimes);
        print(waitTime);
    }
    public int nextMetroTime(List<Integer> stopTimes){
        return timeCalculator.nextMetro(stopTimes);
    }

    private void print(int waitTime){
        System.out.println(waitTime + " minutes until your transportation arrives.");
    }

    private void print(TreeSet<String> nameSet){
        Iterator<String> itr = nameSet.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}