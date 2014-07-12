
package com.rmoore8869.mario4;

public final class Pyramid {

    private final int pyramidSteps;
    private final String pyramidName;

    private int getPyramidSteps(){
        return pyramidSteps;
    }
    private String getPyramidName(){
        return pyramidName;
    }

    private Pyramid(int pyramidSteps, String pyramidName){
        this.pyramidSteps=pyramidSteps;
        this.pyramidName=pyramidName;
    }

    public String thisPyramidName(){
        return pyramidName;
    }
    public int thisPyramidSteps(){
        return pyramidSteps;
    }



}

