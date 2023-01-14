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
package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import model.Car;

/**
 *
 * @author Lucas Requilé
 */
public class GameView extends Region {
    private AnchorPane anchorPane;
    private AnchorPane carPane;
    private AnchorPane trackPane;
    private ImageView carImgV;
    public final static int SIZE = 5;
    Car model;

    public GameView(Car model, AnchorPane trackPane, Image carimg) {
        this.model = model;
        anchorPane = new AnchorPane();
        this.trackPane = trackPane;
        
        //zet auto in midden van scherm
        carImgV = new ImageView(carimg);
        carImgV.setFitHeight(model.getWidth()*2*SIZE);
        carImgV.setFitWidth(model.getLength()*2*SIZE);
        carImgV.setTranslateX(1920/2);
        carImgV.setTranslateY(1080/2);
        
        carPane = new AnchorPane(carImgV);
        anchorPane.getChildren().addAll(trackPane, carPane);
    }
    
    public void update(){
        getChildren().clear();
        
        trackPane.setTranslateX(-model.getX()*SIZE);
        trackPane.setTranslateY(-model.getY()*SIZE);
        carImgV.setRotate(model.getDegrees());

        getChildren().addAll(anchorPane);
    }

    public static int getSIZE() {
        return SIZE;
    }
    
    public ImageView getImageView(){
        return carImgV;
    }
    
}
