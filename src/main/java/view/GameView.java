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
    public final static int SIZE = 5;
    Car model;

    public GameView(Car model) {
        this.model = model;
        anchorPane = new AnchorPane();
        Rectangle rectangle = new Rectangle(10*SIZE,10*SIZE,SIZE,SIZE);
        rectangle.setFill(Color.ORANGE);
        anchorPane.getChildren().add(rectangle);
    }
    
    public void update(){
        getChildren().clear();
        anchorPane.setTranslateX(model.getX()*SIZE);
        anchorPane.setTranslateY(model.getY()*SIZE);
        getChildren().addAll(anchorPane);
    }

    public static int getSIZE() {
        return SIZE;
    }
    
    
    
    
        
    
}
