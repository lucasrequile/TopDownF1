package be.lucasrequile.topdownf1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.DOWN;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Car;
import model.CarState;
import view.GameView;

public class GameFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane gamePane;

    Car model;
    GameView view;
    private int period = 100;
    private boolean isGasPressed = false;
    private KeyCode keyVar = DOWN;
    
    @FXML
    void initialize() {
        model = new Car(0,0,0,0,CarState.NOTHING);
        view = new GameView(model);
        
        gamePane.getChildren().addAll(view);

        gamePane.setOnKeyPressed(this::keyPressed);
        gamePane.setOnKeyReleased(this::keyReleased);
        view.setFocusTraversable(true);
        MoveCar moveCarModel = new MoveCar(model,this);
        
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(moveCarModel, 0, period);
        update();
    }

    public void keyPressed(KeyEvent k) {
        switch(k.getCode()){
            case UP:
                isGasPressed = true;
                model.setCarState(CarState.ACCELERATING);
                break;
            case DOWN:
                isGasPressed = true;
                model.setCarState(CarState.DECELERATING);
                break;
            case RIGHT:
                model.setCarState(CarState.RIGHT);
                break;
            case LEFT:
                model.setCarState(CarState.LEFT);
                break;
        }
        update();
        keyVar = k.getCode();
    }
    public void keyReleased(KeyEvent k){
        switch(k.getCode()){
            case UP:
                isGasPressed = false;
            case DOWN:
                isGasPressed = false;
        }
        update();
        keyVar = k.getCode();
    }
    
    public void gasCheck(){
        if(isGasPressed==false){
                model.setCarState(CarState.NOTHING);
                update();
        }
    }
    public void update() {
        view.update();
    }
    public int getPeriod() {
        return period;
    }
    public boolean isKeyPressed(){
        return isGasPressed;
    }
}
