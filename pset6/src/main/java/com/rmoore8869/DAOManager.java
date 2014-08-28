package com.rmoore8869;

import com.rmoore8869.dao.Stop;

import java.util.ArrayList;

public interface DAOManager {
    public static final String MetroLink_JDBC = "jdbc:sqlite:metrolink:db";
    public static final String Org_JDBC = "org:sqlite:JDBC";

    public ArrayList<Stop> getMetroStops();

}
