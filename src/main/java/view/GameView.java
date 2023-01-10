/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Car;

/**
 *
 * @author lucas
 */
public class GameView extends Region {
    private AnchorPane anchorPane;
    private AnchorPane carPane;
    private AnchorPane trackPane;
    private Rectangle rectangle;
    private ImageView carImgV;
    public final static int SIZE = 4;
    Car model;

    public GameView(Car model, AnchorPane trackPane) {
        this.model = model;
        anchorPane = new AnchorPane();
        this.trackPane = trackPane;
        
        Image carimg = new Image("car1.png");
        carImgV = new ImageView(carimg);
        carImgV.setFitHeight(model.getWidth()*SIZE);
        carImgV.setFitWidth(model.getLength()*SIZE);
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
    
    
}
