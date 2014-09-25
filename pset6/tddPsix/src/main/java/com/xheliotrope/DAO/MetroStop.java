package com.xheliotrope.DAO;

import com.xheliotrope.MetroLinkDAO;

public class MetroStop implements MetroLinkDAO {
    private String name;
    private String time;

    public void setName(String name) {
        this.name = name;
    }
    public void setTime(String time) { this.time = time;}

    public int getTime() {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        return 60 * hours + minutes;
    }
    public String getName(){
        return name;
    }

}
