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
    private double x;
    private double y;
    
    public GameView(Car model) {
        this.model = model;
        anchorPane = new AnchorPane();
        Rectangle rectangle = new Rectangle(0,0,10,10);
        anchorPane.getChildren().add(rectangle);
        update();
    }
    public void update(){
        getChildren().clear();
        anchorPane.setTranslateX(model.getX());
        anchorPane.setTranslateY(model.getY());
        getChildren().addAll(anchorPane);
    }
    
}
