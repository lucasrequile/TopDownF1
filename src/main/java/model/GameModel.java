/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

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
            
    public ArrayList<Rectangle> drawBoundaries(){
        ArrayList<Rectangle> boundaryRectangles = new ArrayList<Rectangle>();
        Rectangle rectangle1 = new Rectangle(338.1,906.13,684.26,30.81);
        Rectangle rectangle2 = new Rectangle(228.72,512.98,29.46,362.55);
        rectangle2.setTranslateX(-198.16);
        rectangle2.setTranslateY(105.83);
        rectangle2.setRotate(-17.56);
        Rectangle rectangle3 = new Rectangle(156.05,280.53,32.6,264.85);
        rectangle3.setTranslateX(-78.94);
        rectangle3.setTranslateY(42.7);
        rectangle3.setRotate(-11.51);
        Rectangle rectangle4 = new Rectangle(72.4,39.09,29.46,264.85);
        rectangle4.setTranslateX(-69.97);
        rectangle4.setTranslateY(60.48);
        rectangle4.setRotate(-27.82);
        Rectangle rectangle5 = new Rectangle(346.83,-47.14,35.74,351.96);
        rectangle5.setTranslateX(96.08);
        rectangle5.setTranslateY(407.14);
        rectangle5.setRotate(-65.47);
        Rectangle rectangle6 = new Rectangle(613.99,99.47,35.74,269);
        rectangle6.setTranslateX(222.7);
        rectangle6.setTranslateY(769.3);
        rectangle6.setRotate(-72.93);
        Rectangle rectangle7 = new Rectangle(754.97,254.93,35.74,110.16);
        rectangle7.setTranslateX(-51.02);
        rectangle7.setTranslateY(189.03);
        rectangle7.setRotate(-13.5);
        Rectangle rectangle8 = new Rectangle(719.4,331.69,35.74,75.82);
        Rectangle rectangle9 = new Rectangle(659.82,360.29,35.74,75.82);
        rectangle9.setTranslateX(384.1);
        rectangle9.setTranslateY(1127.33);
        rectangle9.setRotate(-98.51);
        Rectangle rectangle10 = new Rectangle(586.63,367.44,35.74,75.82);
        rectangle10.setTranslateX(120.1);
        rectangle10.setTranslateY(948.56);
        rectangle10.setRotate(-82.12);
        Rectangle rectangle11 = new Rectangle(468.61,267.35,35.74,194.51);
        rectangle11.setTranslateX(-47.18);
        rectangle11.setTranslateY(655.81);
        rectangle11.setRotate(-65.47);
        Rectangle rectangle12 = new Rectangle(344.32,272.3,35.74,101.98);
        rectangle12.setTranslateX(82.09);
        rectangle12.setTranslateY(719.84);
        rectangle12.setRotate(-96.52);
        Rectangle rectangle13 = new Rectangle(5.87,6.19,35.74,60.6);
        rectangle13.setTranslateX(39.44);
        rectangle13.setTranslateY(77.1);
        rectangle13.setRotate(-168.08);
        Rectangle rectangle14 = new Rectangle(280.75,319.02,35.74,101.98);
        rectangle14.setTranslateX(449.14);
        rectangle14.setTranslateY(821.05);
        rectangle14.setRotate(-159.55);
        Rectangle rectangle15 = new Rectangle(368.2,552.5,35.74,101.98);
        rectangle15.setTranslateX(-250.44);
        rectangle15.setTranslateY(932.3);
        rectangle15.setRotate(-84.71);
        Rectangle rectangle16 = new Rectangle(451.44,530.01,35.74,101.98);
        rectangle16.setTranslateX(223.4);
        rectangle16.setTranslateY(1286.23);
        rectangle16.setRotate(-121.85);
        Rectangle rectangle17 = new Rectangle(533.56,494.66,35.74,101.98);
        rectangle17.setTranslateX(93.33);
        rectangle17.setTranslateY(1171.71);
        rectangle17.setRotate(-98.51);
        Rectangle rectangle18 = new Rectangle(709.73,431.19,35.74,283.07);
        rectangle18.setTranslateX(-27.91);
        rectangle18.setTranslateY(1108.1);
        rectangle18.setRotate(-73.53);
        Rectangle rectangle19 = new Rectangle(939.68,511.35,43.53,258.94);
        rectangle19.setTranslateX(114.16);
        rectangle19.setTranslateY(1426.41);
        rectangle19.setRotate(-76.52);
        Rectangle rectangle20 = new Rectangle(1025.42,856.68,43.53,111.07);
        rectangle20.setTranslateX(372.89);
        rectangle20.setTranslateY(2126.32);
        rectangle20.setRotate(-102.01);
        Rectangle rectangle21 = new Rectangle(1078.2,665.68,38.88,246.53);
        Rectangle rectangle22 = new Rectangle(297.27,843.88,35.74,101.98);
        Rectangle rectangle23 = new Rectangle(297.27,394.09,35.74,211.46);
        rectangle23.setTranslateX(766.42);
        rectangle23.setTranslateY(881.24);
        rectangle23.setRotate(162.44);
        Rectangle rectangle24 = new Rectangle(105.26,-53.4,34.76,177.47);
        rectangle24.setTranslateX(62.73);
        rectangle24.setTranslateY(148.03);
        rectangle24.setRotate(-78.08);
        
        boundaryRectangles.add(rectangle1);
        boundaryRectangles.add(rectangle2);
        boundaryRectangles.add(rectangle3);
        boundaryRectangles.add(rectangle4);
        boundaryRectangles.add(rectangle5);
        boundaryRectangles.add(rectangle6);
        boundaryRectangles.add(rectangle7);
        boundaryRectangles.add(rectangle8);
        boundaryRectangles.add(rectangle9);
        boundaryRectangles.add(rectangle10);
        boundaryRectangles.add(rectangle11);
        boundaryRectangles.add(rectangle12);
        boundaryRectangles.add(rectangle13);
        boundaryRectangles.add(rectangle14);
        boundaryRectangles.add(rectangle15);
        boundaryRectangles.add(rectangle16);
        boundaryRectangles.add(rectangle17);
        boundaryRectangles.add(rectangle18);
        boundaryRectangles.add(rectangle19);
        boundaryRectangles.add(rectangle20);
        boundaryRectangles.add(rectangle21);
        boundaryRectangles.add(rectangle22);
        boundaryRectangles.add(rectangle23);
        boundaryRectangles.add(rectangle24);
        
        return boundaryRectangles;
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
