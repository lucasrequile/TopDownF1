package model;

import javax.vecmath.Vector2d;
/**
 *
 * @author Lucas Requilé
 */
public class Car {
    //car-based vars
    private int width = 2;
    private int length = 5;
    private double x = 0;
    private double y = 0;
    private double degrees = 0;
    private double speed =0;
    private double topSpeed = 85; //top-speed of F1 car (m/s)
    private double acceleration = 12; //acceleratie in m/s² (F1)
    private double deceleration = -60; //deceleratie in m/s² (F1)
    private double bulgeOutDeceleration = -5; //uitbolsnelheid in m/s;
    private GasState gasState;
    private SteerState steerState;
    
    //time-based vars
    private double elapsedTime;
    private long startTime;
    private long endTime;
    

    public Car(double x, double y, double degrees, int width, int length, double topSpeed, double acceleration,double deceleration,double bulgeOutDeceleration,GasState gasState, SteerState steerState) {
        this.width = width;
        this.length = length;        
        this.x = x;
        this.y = y;
        this.degrees = degrees;
        //set-once vars
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
        this.bulgeOutDeceleration = bulgeOutDeceleration;
        this.gasState = gasState;
        this.steerState = steerState;
    }
    
    public void resetCar(){
        x = y = speed = degrees =  0;
        gasState = GasState.IDLE;
        steerState = SteerState.IDLE;
    }
    
    public void gas(GasState gasState){
        switch(gasState){
            case IDLE:
                speed = Math.max(speed + bulgeOutDeceleration*elapsedTime, 0);
                break;
            case ACCELERATING:
                speed = Math.min(speed + acceleration*elapsedTime, topSpeed);
                break;
            case DECELERATING:
                speed = Math.max(speed + deceleration*elapsedTime, 0);
                break;
        }
    }
    public void steer(SteerState steerState){
        switch(steerState){
            case RIGHT:
                if(speed>0){
                degrees = degrees + 2;
                }else{}
                break;
            case LEFT:
                if(speed>0){
                degrees = degrees - 2;
                }else{}
                break;
        }
    }
public void position(){
        gas(gasState);
        steer(steerState);
        double rad = Math.toRadians(degrees);
        double speedX= speed*Math.cos(rad);
        double speedY= speed*Math.sin(rad);
        
        endTime = System.currentTimeMillis();
        long elapsedTimeMilliSec = endTime - startTime;
        elapsedTime = (double)elapsedTimeMilliSec/1000;
        startTime = endTime;
        
        x=x+speedX*elapsedTime;
        y=y+speedY*elapsedTime;
        System.out.println(degrees + " degrees, " + rad + " rad, " + Math.cos(rad)+ " cos, " + speedX + " m/s X, " + speedY+ " m/s Y, ");
        System.out.println(x + ", " + y);
        System.out.println(speed*3.6 + " km/h");
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
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

    public GasState getGasState() {
        return gasState;
    }

    public void setGasState(GasState gasState) {
        this.gasState = gasState;
    }

    public SteerState getSteerState() {
        return steerState;
    }

    public void setSteerState(SteerState steerState) {
        this.steerState = steerState;
    }
   
}
