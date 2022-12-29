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
        model.position();
        Platform.runLater(controller::move);
        Platform.runLater(controller::update);
    }
}
