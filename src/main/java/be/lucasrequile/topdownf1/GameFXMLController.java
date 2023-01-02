package be.lucasrequile.topdownf1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Car;
import model.GasState;
import model.SteerState;
import model.TrackModel;
import view.CarView;
import view.GameView;
import view.TrackView;

public class GameFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane gamePane;
    
    
    TrackModel trackModel;
    Car carModel;
    GameView view;
    
    CarView carView;
    TrackView trackView;
    
    private boolean isGasPressed = false;
    private boolean isSteered = false;
    
    @FXML
    void initialize() {
        trackModel = new TrackModel(338,666);
        carModel = new Car(0,0,0,2,5,85,12,-60, -5,GasState.IDLE, SteerState.IDLE);
        
        view = new GameView(carModel);
        
        carView = new CarView(carModel);
        trackView = new TrackView(trackModel);
        
        gamePane.getChildren().addAll(view,trackView, carView);
        
        gamePane.setOnKeyPressed(this::keyPressed);
        gamePane.setOnMouseClicked(this::reset);
        gamePane.setOnKeyReleased(this::keyReleased);
        view.setFocusTraversable(true);
        CarTimer moveCarModel = new CarTimer(carModel,this);
        
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(moveCarModel, 0, 20);
        update();
    }

    public void keyPressed(KeyEvent k) {
        switch(k.getCode()){
            case UP:
                isGasPressed = true;
                carModel.setGasState(GasState.ACCELERATING);
                break;
            case DOWN:
                isGasPressed = true;
                carModel.setGasState(GasState.DECELERATING);
                break;
            case RIGHT:
                carModel.setSteerState(SteerState.RIGHT);
                break;
            case LEFT:
                carModel.setSteerState(SteerState.LEFT);
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
            carModel.setGasState(GasState.IDLE);
            update();
        }
        if(isSteered == false){
            carModel.setSteerState(SteerState.IDLE);
            update();
        }
    }
    public void update() {
        view.update();
        carView.update();
        trackView.update();
    }
    public boolean isKeyPressed(){
        return isGasPressed;
    }

    private void reset(MouseEvent m) {
        carModel.resetCar();
    }
}
