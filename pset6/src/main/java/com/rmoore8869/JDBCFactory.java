package com.rmoore8869;


import com.rmoore8869.dao.Stop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JDBCFactory {

    private SqliteJDBC sqliteJDBC;
    private TimeCalc timeCalc;

    public JDBCFactory(SqliteJDBC sqliteJDBC){
        this.sqliteJDBC = sqliteJDBC;
    }
    private SqliteJDBC getSqliteJDBC(){
        return this.sqliteJDBC;
    }
    private void setSqliteJDBC(SqliteJDBC sqliteJDBC){
        this.sqliteJDBC = sqliteJDBC;
    }

    public void getNextMetro(){
        timeCalc = new TimeCalc(metroStopTimes(currentLocation()));
        print(timeCalc.nextMetro());
    }

    private ArrayList<Integer> metroStopTimes(String currentStop) {
        List<Stop> stops = sqliteJDBC.getMetroStops();
        ArrayList<Integer> stopTimesInMinutes = new ArrayList<>();
        int iterator = 0;
        for (Stop stop : stops) {
            if (stop.stop_name.equals(currentStop)) {
                stopTimesInMinutes.add(stop.arrival_time_minutes);
                iterator++;
            }
        }
        return stopTimesInMinutes;
    }

    private static String currentLocation(){
        System.out.println("Please enter the name of your current stop.");
        System.out.println("Use the format: ");
        System.out.println("STATION A @ REGULAR RD \n");
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String inputString = input.readLine();
            return inputString.toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException();
    }
    private void print(int waitTime){
        System.out.println(waitTime + " minutes until your transportation arrives.");
    }

    private boolean stopChecker(ArrayList<Integer> arrayList){
        if (arrayList.isEmpty()){
            return true;
        }
        return false;
    }
}
