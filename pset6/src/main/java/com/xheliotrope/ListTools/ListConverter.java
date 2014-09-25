package com.xheliotrope.ListTools;

import com.xheliotrope.DAO.MetroStop;

import java.util.*;

public class ListConverter {

    private List<Integer> stopTimesInMinutes;
    private List<MetroStop> stops;
    private TreeSet<String> nameSet;

    private ListConverter(List<MetroStop> stops){
        this.stops = stops;
    }

    public List<Integer> getStopTimes(String name){
        populateMetroStopTimes(name);
        return getStopTimesInMinutes();
    }

    public TreeSet<String> getNameSet(String firstChar){
        populateNameListFromStops(firstChar);
        return nameSet;
    }

    private List<Integer> getStopTimesInMinutes(){
        return stopTimesInMinutes;
    }

    private void populateMetroStopTimes(String name) {
        stopTimesInMinutes = new ArrayList<>();
        for (MetroStop stop : stops) {
            if(name.equalsIgnoreCase(stop.getName())) {
                stopTimesInMinutes.add(stop.getTime());
            }
        }
    }

    private void populateNameListFromStops(String firstChar){
        nameSet = new TreeSet<>();
        firstChar = firstChar.toUpperCase();
        for(MetroStop stop : stops){
            String stopName = stop.getName();
            if(stopName.startsWith(firstChar)){
                nameSet.add(stop.getName());
            }
        }
    }
}
