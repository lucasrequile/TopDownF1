/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import model.Car;

/**
 *
 * @author lucas
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
        
        carImgV = new ImageView(carimg);
        carImgV.setFitHeight(model.getWidth()*2*SIZE);
        carImgV.setFitWidth(model.getLength()*2*SIZE);
        carImgV.setTranslateX(1920/2);
        carImgV.setTranslateY(1080/2);
        
        /*rectangle = new Rectangle(1920/2,1080/2,model.getLength()*SIZE,model.getWidth()*SIZE);
        rectangle.setFill(Color.ORANGE);*/
        
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
