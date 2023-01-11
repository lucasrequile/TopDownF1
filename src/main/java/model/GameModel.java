/*
 * Copyright (C) 2023 Lucas Requilé
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package model;

/**
 *
 * GameModel houdt globale spelgebonden variabelen bij, zoals de snelste ronde, en de huidige rondetijd.
 * @author Lucas Requilé
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

    /**
     *
     * @param carModel Zie car-klasse
     */
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
