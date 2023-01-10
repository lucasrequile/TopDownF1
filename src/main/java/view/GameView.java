/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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
    public final static int SIZE = 2;
    Car model;

    public GameView(Car model, AnchorPane trackPane) {
        this.model = model;
        anchorPane = new AnchorPane();
        this.trackPane = trackPane;
        
        rectangle = new Rectangle(1920/2,1080/2,model.getLength()*SIZE,model.getWidth()*SIZE);
        rectangle.setFill(Color.ORANGE);
        
        carPane = new AnchorPane(rectangle);
        anchorPane.getChildren().addAll(trackPane, rectangle);
    }
    
    public void update(){
        getChildren().clear();
        
        trackPane.setTranslateX(-model.getX()*SIZE);
        trackPane.setTranslateY(-model.getY()*SIZE);
        
        rectangle.setRotate(model.getDegrees());

        getChildren().addAll(anchorPane);
    }

    public static int getSIZE() {
        return SIZE;
    }
    
    
}
