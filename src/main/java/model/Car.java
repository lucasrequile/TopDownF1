/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lucas
 */
public class Car {
    private double x = 10;
    private double y = 10;
    private Direction direction;

    public Car(double x, double y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    
    public void resetCar(){
        x = y = 0;
    }
    
    public void tick(){
        switch(direction){
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;    
                break;
        }
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }    
}
