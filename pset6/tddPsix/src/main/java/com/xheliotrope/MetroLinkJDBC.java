package com.xheliotrope;

import com.xheliotrope.DAO.MetroStop;
import java.sql.*;
import java.util.*;

public class MetroLinkJDBC {
    private final String Org_JDBC = "org.sqlite.JDBC";
    private final String MetroLink_JDBC = "jdbc:sqlite:metrolink.db";
    private List<MetroStop> stopList;

    private MetroLinkJDBC(){}

    public List<MetroStop> getStopListFromStops(){
        makeStopListFromDatabase();
        return stopList;
    }


    private void makeStopListFromDatabase() {
        stopList = new ArrayList<>();
        try (Connection connection = getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT stop_name, arrival_time " +
                    "FROM stops JOIN stop_times ON stops.stop_id=stop_times.stop_id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MetroStop stop = new MetroStop();
                stop.setName(resultSet.getString("stop_name"));
                stop.setTime(resultSet.getString("arrival_time"));
                stopList.add(stop);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    private Connection getConnection() {
        try {
            System.out.println("Connecting to database...");
            Class.forName(Org_JDBC);
            return DriverManager.getConnection(MetroLink_JDBC);
        } catch (ClassNotFoundException |SQLException e2){
            e2.printStackTrace();
        }
        finally{
            System.out.println("Connection process finished.");
        }
        throw new IllegalStateException();
    }

}
