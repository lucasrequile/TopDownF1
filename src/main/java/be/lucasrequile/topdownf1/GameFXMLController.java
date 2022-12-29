package be.lucasrequile.topdownf1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
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
    private boolean isGasPressed = false;
    
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
        t.scheduleAtFixedRate(moveCarModel, 0, 30);
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
    }
    public void keyReleased(KeyEvent k){
        switch(k.getCode()){
            case UP:
                isGasPressed = false;
            case DOWN:
                isGasPressed = false;
        }
        update();
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
    public boolean isKeyPressed(){
        return isGasPressed;
    }
}
