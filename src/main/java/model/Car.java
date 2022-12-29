/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import be.lucasrequile.topdownf1.GameFXMLController;
import be.lucasrequile.topdownf1.MoveCar;

/**
 *
 * @author lucas
 */
public class Car {
    private double x = 0;
    private double y = 0;
    private double speed =0;
    private double topSpeed = 83; //top-speed of F1 car (m/s)
    private double acceleration = 12; //acceleratie in m/s² (F1)
    private double deceleration = -60; //deceleratie in m/s² (F1)
    private double bulgeOutDeceleration = -10; //uitbolsnelheid in m/s;
    private double degrees = 0;
    private int period;
    private int movementsPerSecond;
    private double pixelToMeterRatio = 1;

    public Car(double x, double y, double speed, double acceleration, double degrees, int period) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.degrees = degrees;
        this.period = period;
        movementsPerSecond = 1000/period;
    }
    
    public void resetCar(){
        x = y = 0;
    }
    
    public void accelerate(){
        speed = Math.min(speed + acceleration/(double)movementsPerSecond, topSpeed);
        /* stel dat de stappen van acceleratie groter zijn dan de topSpeed, zal hij gewoon de topSpeed kiezen ipv de berekening */
    }
    public void decelerate(){
        speed = Math.max(speed + deceleration /(double)movementsPerSecond, 0);
        /*in plaats van een if, zorgt Math.max ervoor dat wanneer de decelleratie groter is dan de acceleratie 
        de snelheid toch niet negatief kan worden. Hij neemt de grootste van beide waarden terug, dus v kan nooit <0 zijn.*/
    }
    public void left(){
        if(speed>0){
            degrees = degrees - 3;
        }else{
        }
    }
    public void right(){
        if(speed>0){
        degrees = degrees + 3;
        }else{}
    }
    public void nothingPressed(){
        speed = Math.max(speed + bulgeOutDeceleration /(double)movementsPerSecond, 0);
    }

public void position(){
        double rad = Math.toRadians(degrees);
        double speedX= speed*Math.cos(rad);
        double speedY= speed*Math.sin(rad);
        
        x=x+speedX;
        y=y+speedY;
        System.out.println(degrees + ", " + rad + ", " + Math.cos(rad)+ ", " + speedX + ", " + speedY);
        System.out.println(x + ", " + y);
        System.out.println(speed*3.6 + "kmh");
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }
    
    

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
