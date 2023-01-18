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

import javafx.scene.image.Image;

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
    private GasState gasState = GasState.IDLE;
    private SteerState steerState = SteerState.IDLE;
    private double elapsedTime;
    private long startTime;
    private long endTime;
    private Image img = new Image("ferrariF1.png");;
    
    /**
     *
     * @param degrees starthoek in graden
     * @param width breedte van auto
     * @param length lengte van auto
     * @param topSpeed topsnelheid van auto(m/s)
     * @param acceleration acceleratie van auto (m/s2)
     * @param deceleration deceleratie van auto (m/s2)
     * @param bulgeOutDeceleration deceleratie van auto wanneer er niets gebeurd (m/s2)
     * @param carimg foto van auto
     */
    public Car(double degrees, int width, int length, double topSpeed, double acceleration,double deceleration,double bulgeOutDeceleration, Image carimg) {
        this.width = width;
        this.length = length;
        this.degrees = degrees;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
        this.bulgeOutDeceleration = bulgeOutDeceleration;
        this.img = carimg;
    }
    
    /**
     * Auto wordt gereset naar (0,0)
     */
    public void resetCar(){
        x = y = speed = 0;
        degrees = 180;
        gasState = GasState.IDLE;
        steerState = SteerState.IDLE;
    }
    
    /**
     *
     * @param gasState status van het gaspedaal
     */
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

    /**
     *
     * @param steerState status van het stuur
     */
    public void steer(SteerState steerState){
        switch(steerState){
            case RIGHT:
                if(speed>0){
                degrees++;
                }else{}
                break;
            case LEFT:
                if(speed>0){
                degrees--;
                }else{}
                break;
        }
    }

    /**
     *  Methode position bepaalt de volgende x en y coordinaten vanuit de snelheid en de tijd tussen 2 ticks.
     */
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
        /*System.out.println(degrees + " degrees, " + rad + " rad, " + Math.cos(rad)+ " cos, " + speedX + " m/s X, " + speedY+ " m/s Y, ");
        System.out.println(x + ", " + y);
        System.out.println(speed*3.6 + " km/h");*/
    }

    /**
     *
     * @return Breedte auto
     */
    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
    
    public double getSpeed() {
        return speed;
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

    public double getY() {
        return y;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public void setDeceleration(double deceleration) {
        this.deceleration = deceleration;
    }

    public void setBulgeOutDeceleration(double bulgeOutDeceleration) {
        this.bulgeOutDeceleration = bulgeOutDeceleration;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getDeceleration() {
        return deceleration;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
