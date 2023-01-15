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
public enum CarEnum {
    FERRARIF1("Ferrari F1-75",2,5,85,12,-60,-5,new Image("ferrariF1.png")),
    REDBULLF1("Red Bull RB18",2,5,85,12,-60,-5,new Image("redbullcar.png")),
    BMWROADCAR("BMW M8",2,5,70,7,-40,-5,new Image("BMWM8.png"));
    
    private final String name;
    private final int width;
    private final int length;
    private final double topSpeed;
    private final double acceleration;
    private final double deceleration;
    private final double bulgeOutDeceleration;
    private final Image img;
    
    CarEnum(String name, int width, int length, double topSpeed, double acceleration, double deceleration, double bulgeOutDeceleration, Image img){
        this.name = name;
        this.width = width;
        this.length = length;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
        this.bulgeOutDeceleration = bulgeOutDeceleration;
        this.img = img;
    }
    
    public String getName(){
        return name;
    }
    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
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

    public double getBulgeOutDeceleration() {
        return bulgeOutDeceleration;
    }

    public Image getImg() {
        return img;
    }
    
}
