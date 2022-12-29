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
    private double topSpeed = 85; //top-speed of F1 car (m/s)
    private double acceleration = 12; //acceleratie in m/s² (F1)
    private double deceleration = -60; //deceleratie in m/s² (F1)
    private double bulgeOutDeceleration = -10; //uitbolsnelheid in m/s;
    private double degrees = 0;
    private double pixelToMeterRatio = 1;
    
    private double elapsedTime;
    private long startTime;
    private long endTime;

    public Car(double x, double y, double speed, double degrees) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.degrees = degrees;
    }
    
    public void resetCar(){
        x = y = 0;
    }
    
    public void accelerate(){
        speed = Math.min(speed + acceleration*elapsedTime, topSpeed);
        /* stel dat de stappen van acceleratie groter zijn dan de topSpeed, zal hij gewoon de topSpeed kiezen ipv de berekening */
    }
    public void decelerate(){
        speed = Math.max(speed + deceleration*elapsedTime, 0);
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
        speed = Math.max(speed + bulgeOutDeceleration*elapsedTime, 0);
    }

public void position(){
        double rad = Math.toRadians(degrees);
        double speedX= speed*Math.cos(rad);
        double speedY= speed*Math.sin(rad);
        
        endTime = System.currentTimeMillis();
        long elapsedTimeMilliSec = endTime - startTime;
        elapsedTime = (double)elapsedTimeMilliSec/1000;
        startTime = endTime;
        System.out.println("elapsed time = "+elapsedTime);
        
        x=x+speedX*elapsedTime;
        y=y+speedY*elapsedTime;
        System.out.println(degrees + " degrees, " + rad + " rad, " + Math.cos(rad)+ " cos, " + speedX + " m/s X, " + speedY+ " m/s Y, ");
        System.out.println(x + ", " + y);
        System.out.println(speed*3.6 + " km/h");
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
