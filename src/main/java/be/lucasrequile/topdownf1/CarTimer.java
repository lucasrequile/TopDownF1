package be.lucasrequile.topdownf1;

import java.util.TimerTask;
import javafx.application.Platform;
import model.Car;
import model.GameModel;

/**
 *
 * @author lucas
 */
public class CarTimer extends TimerTask {
    private Car model;
    private GameModel gameModel;
    private GameFXMLController controller;

    public CarTimer(Car model, GameModel gameModel, GameFXMLController controller) {
        this.model = model;
        this.gameModel = gameModel;
        this.controller = controller;
    }
    
    public void run(){
        gameModel.updateLaptime();
        Platform.runLater(controller::gasSteerCheck);
        model.position();
        Platform.runLater(controller::update);
    }
}
