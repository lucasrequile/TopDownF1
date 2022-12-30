package be.lucasrequile.topdownf1;

import java.util.TimerTask;
import javafx.application.Platform;
import model.Car;

/**
 *
 * @author lucas
 */
public class CarTimer extends TimerTask {
    private Car model;
    private GameFXMLController controller;

    public CarTimer(Car model, GameFXMLController controller) {
        this.model = model;
        this.controller = controller;
    }
    
    public void run(){
        Platform.runLater(controller::gasSteerCheck);
        model.position();
        Platform.runLater(controller::update);
    }
}
