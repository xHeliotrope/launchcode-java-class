
package com.rmoore8869.mario4;


public class Pyramid {

    protected String pyramidVisual;
    protected int pyrSteps;
    protected MarioFileWriter mfw;

    public Pyramid(){}

    public void start() {
        pyramidVisual = stepBuilder(pyrSteps);
        pyrStepsChecker(pyrSteps);
        mfw.outputTriangle(pyramidVisual);
    }

    private void pyrStepsChecker(int pyrSteps) {
        while (pyrSteps < 0 || pyrSteps > 23) {
            System.out.println("Pyramid size out of allowable region, zeroing-out this pyramid");
            pyrSteps=0;
        }
    }

    public void setMarioFileWriter(MarioFileWriter mfw){
        this.mfw = mfw;
    }
    public MarioFileWriter getMarioFileWriter(){
        return mfw;
    }
    public void setPyrSteps(int pyrSteps){
        this.pyrSteps = pyrSteps;
    }
    public int getPyrSteps(){
        return pyrSteps;
    }
    public void setPyramidVisual(String pyramidVisual){
        this.pyramidVisual=pyramidVisual;
    }
    public String getPyramidVisual(){
        return pyramidVisual;
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

}
