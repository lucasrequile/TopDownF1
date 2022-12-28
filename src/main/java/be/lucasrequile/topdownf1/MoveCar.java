/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.lucasrequile.topdownf1;

import java.util.TimerTask;
import javafx.application.Platform;
import model.Car;

/**
 *
 * @author lucas
 */
public class MoveCar extends TimerTask {
    private Car model;
    private GameFXMLController controller;

    public MoveCar(Car model, GameFXMLController controller) {
        this.model = model;
        this.controller = controller;
    }
    
    public void run(){
        model.tick();
        Platform.runLater(controller::update);
    }
}
