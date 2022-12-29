package model;
/**
 *
 * @author Lucas Requilé
 */
public class Car {
    private double x = 0;
    private double y = 0;
    private double speed =0;
    private double topSpeed = 85; //top-speed of F1 car (m/s)
    private double acceleration = 12; //acceleratie in m/s² (F1)
    private double deceleration = -60; //deceleratie in m/s² (F1)
    private double bulgeOutDeceleration = -5; //uitbolsnelheid in m/s;
    private double degrees = 0;
    private double pixelToMeterRatio = 1;
    
    private double elapsedTime;
    private long startTime;
    private long endTime;
    private CarState carState;

    public Car(double x, double y, double speed, double degrees, CarState carState) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.degrees = degrees;
        this.carState = carState;
    }
    
    public void resetCar(){
        x = y = 0;
    }
    
    public void movement(CarState carState){
        switch(carState){
            case NOTHING:
                speed = Math.max(speed + bulgeOutDeceleration*elapsedTime, 0);
                break;
            case ACCELERATING:
                speed = Math.min(speed + acceleration*elapsedTime, topSpeed);
                break;
            case DECELERATING:
                speed = Math.max(speed + deceleration*elapsedTime, 0);
                break;
            case RIGHT:
                if(speed>0){
                degrees = degrees + 3;
                }else{}
                break;
            case LEFT:
                if(speed>0){
                degrees = degrees - 3;
                }else{}
                break;
        }
    }
public void position(){
        movement(carState);
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

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }
    
}
