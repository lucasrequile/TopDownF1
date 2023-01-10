/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lucas
 */
public class GameModel {
    private double laptime;
    private int laps;
    private boolean isOnFinish = false;
    private long endTime;
    private long startTime;
    private double elapsedTime;
    private Car carModel;

    public GameModel(Car carModel) {
        startTime = System.currentTimeMillis();
        laptime = 0;
        this.carModel = carModel;
    }
    
    public double updateLaptime(){
        endTime = System.currentTimeMillis();
        long elapsedTimeMilliSec = endTime - startTime;
        elapsedTime = (double)elapsedTimeMilliSec/1000;
        startTime = endTime;
        
        laptime = laptime + elapsedTime;
        
        //voorbij de finish komen
        if((int)carModel.getX()==0 && ((int)carModel.getY()<20 || (int)carModel.getY()>20)){
            laps++; //VERBETEREN
            resetLaptime();
        }
        return laptime;
    }
    
    
    public String timeToString(){
        int minutes = (int)laptime/60;
        int seconds = (int)laptime - minutes*60;
        double milliseconds = (laptime - minutes*60 - seconds)*1000;
        
        return minutes + ":" + seconds + ":" + (int)milliseconds;
    }
    
    public int getLaps(){
        return laps;
    }
    
    public void resetLaptime(){
        laptime = 0;
    }
    
    
}
