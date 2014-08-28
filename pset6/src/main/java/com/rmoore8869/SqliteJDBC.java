package com.rmoore8869;

import java.sql.*;
import com.rmoore8869.dao.*;
import java.util.*;

public class SqliteJDBC implements DAOManager{
    public static final String MetroLink_JDBC = "jdbc:sqlite:metrolink:db";
    public static final String Org_JDBC = "org:sqlite:JDBC";

    public SqliteJDBC(){}
    public ArrayList<Stop> getMetroStops(){
        ArrayList<Stop> myAL = getStopsFromStops();
        return myAL;
    }

    private ArrayList<Stop> getStopsFromStops() {
        ArrayList<Stop> stopsList;
        try (Connection connection = getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT stop_name, arrival_time " +
                    "FROM stops JOIN stop_times ON stops.stop_id=stop_times.stop_id");
            ResultSet resultSet = preparedStatement.executeQuery();
            stopsList = new ArrayList<>();
            while (resultSet.next()) {
                Stop stop = new Stop();
                stop.setName(resultSet.getString("stop_name"));
                System.out.println(resultSet.getString("stop_name"));
                stop.setNextTimeMinutes(resultSet.getString("arrival_time"));
                stopsList.add(stop);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new IllegalStateException("unable to execute the Query");
        }
        //to be flagged better/handled
        if(stopsList == null){
            throw new NullPointerException();
        }
        return stopsList;
    }

    private Connection getConnection() throws SQLException{
        try{
            System.out.println("Connecting to database...");
            Class.forName(Org_JDBC);
            return DriverManager.getConnection(MetroLink_JDBC);
        }
        catch(Exception e2){
            throw new IllegalStateException("unable to resolve the Connection");
        }
        finally{
            System.out.println("Connection process finished.");
        }
        }
}

