package com.rmoore8869;

import org.joda.time.DateTime;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

public class TimeCalc {

    private int nextMetro;
    public TimeCalc(){}
    public TimeCalc(ArrayList<Integer> stationStopTimes){
        this.nextMetro = timeDifference(stationStopTimes);
    }
    public int nextMetro(){
        return nextMetro;
    }

    private int timeDifference(ArrayList<Integer> stationStoptimes) {
        Collections.sort(stationStoptimes);
        for(int i = 0; i < 99 ; i++){
            if( stationStoptimes.get(i) > timeRetriever()) {
                return stationStoptimes.get(i) - timeRetriever();
            }
        }
        return ((1440-timeRetriever()+stationStoptimes.get(0)));
    }

    private int timeRetriever() {
        DateTime dateTime = new DateTime();
        Timestamp timeStamp = new Timestamp(dateTime.getMillis());
        String hoursTime = timeStamp.toString().substring(11, 13);
        String minutesTime = timeStamp.toString().substring(14, 16);
        return (Integer.parseInt(hoursTime) * 60 + Integer.parseInt(minutesTime));
    }

}
