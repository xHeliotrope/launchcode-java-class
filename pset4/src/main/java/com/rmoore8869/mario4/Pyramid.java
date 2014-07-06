
package com.rmoore8869.mario4;


import java.util.concurrent.TimeUnit;


public class Pyramid {

    protected int pyramidSteps;
    protected String pyramidName;
    protected String pyramidVisual;
    protected MarioFileWriter mfw;

    public void setMfw(MarioFileWriter mfw) { this.mfw = mfw; }
    public MarioFileWriter getMfw() {
        return mfw;
    }
    public void setPyramidSteps(int pyrSteps) { this.pyramidSteps = pyrSteps; }
    public int getPyramidSteps() {
        return pyramidSteps;
    }
    public void setPyramidName(String pyramidName) { this.pyramidName=pyramidName; }
    public String getPyramidName() { return pyramidName; }

    protected void constructAndDisplay(){
        System.out.println("This is " + pyramidName);
        customWait();
        pyramidVisual = stepBuilder(pyramidSteps);
        pyramidStepsDependencyChecker(pyramidSteps);
        mfw.outputTriangle(pyramidVisual);
        customWait();
    }

    private void pyramidStepsDependencyChecker(int pyrSteps) {
        while (pyrSteps < 0 || pyrSteps > 23) {
            System.out.println("Zeroing-out this pyramid");
            pyrSteps = 0;
        }
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
    private void customWait(){
        try{TimeUnit.SECONDS.sleep(1);}
        catch(InterruptedException e){System.out.println("Interrupted");}
    }
}
