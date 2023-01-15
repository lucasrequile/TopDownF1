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
import model.CarEnum;

/**
 *PrimaryModel is een Model-klasse die in het leven is geroepen om te kunnen wisselen tussen 2 FXML-files en controllers, zonder data te verliezen.
 * 
 * @author Lucas Requilé
 */
public class PrimaryModel {
    private Car car;
    private int width = 2;
    private int length = 5;
    private double topSpeed = 85;
    private double acceleration = 12;
    private double deceleration = -60;
    private double bulgeOutDeceleration = -5;
    private GameModel gameModel;
    private TrackModel trackModel;
    private String svgCode;
    private Image img = new Image("ferrariF1.png");
    
    
    public PrimaryModel() {
        car = new Car(180, width, length, topSpeed, acceleration, deceleration, bulgeOutDeceleration, img);
        gameModel = new GameModel(car);
        trackModel = new TrackModel(svgCode, 0, 0, 0,0);
    }
    
    public void carChoice(CarEnum carModel){
        car.setWidth(carModel.getWidth());
        car.setLength(carModel.getLength());
        car.setTopSpeed(carModel.getTopSpeed());
        car.setAcceleration(carModel.getAcceleration());
        car.setDeceleration(carModel.getDeceleration());
        car.setBulgeOutDeceleration(carModel.getBulgeOutDeceleration());
        car.setImg(carModel.getImg());
}
    public void trackChoice(TrackEnum track){
        trackModel.setTrackSVGCode(track.getTrackSVGCode());
        trackModel.setSvgHeight(track.getSvgHeight());
        trackModel.setSvgWidth(track.getSvgWidth());
        trackModel.setxCoStart(track.getxCoStart());
        trackModel.setyCoStart(track.getyCoStart());
    }

    public Car getCar() {
        return car;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public TrackModel getTrackModel() {
        return trackModel;
    }
}
