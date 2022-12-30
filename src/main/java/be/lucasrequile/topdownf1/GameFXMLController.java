package be.lucasrequile.topdownf1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
import static javafx.scene.input.KeyCode.DOWN;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Car;
import model.GasState;
import model.SteerState;
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
    private boolean isSteered = false;
    
    @FXML
    void initialize() {
        model = new Car(0,0,0,GasState.IDLE, SteerState.IDLE);
        view = new GameView(model);
        
        gamePane.getChildren().addAll(view);

        gamePane.setOnKeyPressed(this::keyPressed);
        gamePane.setOnKeyReleased(this::keyReleased);
        view.setFocusTraversable(true);
        CarTimer moveCarModel = new CarTimer(model,this);
        
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(moveCarModel, 0, 30);
        update();
    }

    public void keyPressed(KeyEvent k) {
        switch(k.getCode()){
            case UP:
                isGasPressed = true;
                model.setGasState(GasState.ACCELERATING);
                break;
            case DOWN:
                isGasPressed = true;
                model.setGasState(GasState.DECELERATING);
                break;
            case RIGHT:
                model.setSteerState(SteerState.RIGHT);
                break;
            case LEFT:
                model.setSteerState(SteerState.LEFT);
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
            case LEFT:
                isSteered = false;
            case RIGHT:
                isSteered = false;
        }
        update();
    }
    
    public void gasSteerCheck(){
        if(isGasPressed==false){
            model.setGasState(GasState.IDLE);
            update();
        }
        if(isSteered == false){
            model.setSteerState(SteerState.IDLE);
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
