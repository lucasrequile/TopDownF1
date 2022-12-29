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
    private double acceleration = 10; //acceleratie in m/s² (F1)
    private double deceleration = -60; //deceleratie in m/s² (F1)
    private double degrees = 0;

    public Car(double x, double y, double speed, double acceleration, double degrees) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.degrees = degrees;
    }
    
    public void resetCar(){
        x = y = 0;
    }
    
    public void up(){
        speed = speed + acceleration*.1;;
    }
    public void down(){
        if(speed >0){
        speed = speed + deceleration*.1;
        }else{
            speed = 0;
        }
    }
    public void left(){
        degrees = degrees - 5;
    }
    public void right(){
        degrees = degrees + 5;
    }

public void position(){
        double rad = Math.toRadians(degrees);
        double speedX= speed*Math.cos(rad);
        double speedY= speed*Math.sin(rad);
        
        x=x+speedX;
        y=y+speedY;
        System.out.println(degrees + ", " + rad + ", " + speedX + ", " + speedY);
        System.out.println(x + ", " + y);
        
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
