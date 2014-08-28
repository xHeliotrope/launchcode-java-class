package com.rmoore8869.dao;

public class Stop {
    public String stop_name;
    public int arrival_time_minutes;

    public void setName(String name){
        this.stop_name = name;
    }

    //not sure why this method gets initialized first with the value "arrivalTime"
    //before I start feeding values to it. (hence the if statement)
    public void setNextTimeMinutes(String arrivalTime){
        String hourString = arrivalTime.substring(0,2);
        if (hourString.equals("ar")){
            return;
        }
        int hours = Integer.parseInt(hourString);
        String minuteString = arrivalTime.substring(3,5);
        int minutes =Integer.parseInt(minuteString);
        System.out.println(60*hours + minutes);
        this.arrival_time_minutes =  60*hours+minutes;
    }

}
