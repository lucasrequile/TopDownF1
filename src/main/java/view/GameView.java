/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import model.Car;

/**
 *
 * @author lucas
 */
public class GameView extends Region{
    private Car model;
    private AnchorPane anchorPane;
    
    public GameView(Car model) {
        this.model = model;
        
        anchorPane = new AnchorPane();
        
        Rectangle rectangle = new Rectangle(model.getX(),model.getY(),10,10);
        anchorPane.getChildren().addAll(rectangle);
        
        update();
    }
    public void update(){
        double x = model.getX();
        double y = model.getY();
        
        anchorPane.setTranslateX(x);
        anchorPane.setTranslateY(y);
        
    }
    
}
