package com.rmoore8869.mario4;

import java.util.concurrent.TimeUnit;

/**
 * rmoore8869
 * 7/6/2014
 */

public class PyramidFactory {

    private Pyramid pyramid;
    private MarioFileWriter mfw;
    private String pyramidVisual;

    private MarioFileWriter getMfw() {
        return mfw;
    }

    private PyramidFactory(Pyramid pyramid, MarioFileWriter mfw){
        this.pyramid=pyramid;
        this.mfw=mfw;
    }

    public void createPyramid(){
        int pyramidSteps = pyramid.thisPyramidSteps();
        System.out.printf("This is %s%n", pyramid.thisPyramidName());
        customWait();
        if(dependencyChecker(pyramidSteps)==true) return;
        pyramidVisual = stepBuilder(pyramidSteps);
        mfw.outputTriangle(pyramidVisual);
        customWait();
    }

    public void createCustomPyramid(int pyramidSteps, MarioFileWriter mfw, String pyramidName){
        System.out.printf("This is %s%n", pyramidName);
        customWait();
        if (dependencyChecker(pyramidSteps)==true) return;
        pyramidVisual = stepBuilder(pyramidSteps);
        mfw.outputTriangle(pyramidVisual);
        customWait();
    }

    private String stepBuilder(int input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= input; i++) {
            int j = i;
            int k = i;
            while (input - j != 0) {
                sb.append(" ");
                j++;
            }
            while (k > 0) {
                sb.append("#");
                k--;
            }
            sb.append(System.getProperty("line.separator"));
            pyramidVisual = sb.toString();
        }
        return pyramidVisual;
    }

    private boolean dependencyChecker(int pyramidSteps) {
        if (pyramidSteps < 0 || pyramidSteps > 23) {
            System.out.println("Unallowable Pyramid");
            return true;
        }
        return false;
    }

    private void customWait(){
        try{TimeUnit.SECONDS.sleep(1);}
        catch(InterruptedException e){System.out.println("Interrupted");}
    }
}
