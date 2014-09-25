package com.xheliotrope.ListTools;

import java.sql.Timestamp;
import java.util.*;
import org.joda.time.DateTime;

public class TimeCalculator {

    private TimeCalculator() {}

    public int nextMetro(List<Integer> stopTimes) {
        return timeDifference(stopTimes);
    }

    private int timeDifference(List<Integer> stationStopTimes) {
        Collections.sort(stationStopTimes);
        for (int i = 0; i < stationStopTimes.size(); i++) {
            if (stationStopTimes.get(i) > currentTimeinMinutes()) {
                return stationStopTimes.get(i) - currentTimeinMinutes();
            }
        }
        System.out.println("Using the next day's first stop to calculate next available metro." +
                " Unless it is close to midnight, there might be an issue with the dataset.");
        return ((1440 - currentTimeinMinutes() + stationStopTimes.get(0)));
    }

    private int currentTimeinMinutes() {
        DateTime dateTime = new DateTime();
        Timestamp timeStamp = new Timestamp(dateTime.getMillis());
        String hoursTime = timeStamp.toString().substring(11, 13);
        String minutesTime = timeStamp.toString().substring(14, 16);
        return (Integer.parseInt(hoursTime) * 60 + Integer.parseInt(minutesTime));
    }
}
