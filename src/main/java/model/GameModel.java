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
    private double bestLap = 59999;
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
        if((int)carModel.getX()==0 && (int)carModel.getY()<20 && (int)carModel.getY()>-20){
            if(laptime > 10){
                laps++;
                bestLapCheck(laptime);
                resetLaptime();
            }
            if(carModel.getSpeed()==0){
                resetLaptime();
            }
        }
        
        return laptime;
    }
    
    public void bestLapCheck(double laptime){
        if(laptime < bestLap){
            bestLap = laptime;
        }
    }
    
    public String timeToString(double time){
        int minutes = (int)time/60;
        int seconds = (int)time - minutes*60;
        double milliseconds = (time - minutes*60 - seconds)*1000;
        
        return minutes + ":" + seconds + ":" + (int)milliseconds;
    }
    
    public double getLaptime(){
        return laptime;
    }
    public double getBestLap(){
        return bestLap;
    }
    
    public int getLaps(){
        return laps;
    }
    
    public void resetLaptime(){
        laptime = 0;
    }
    
    
}
