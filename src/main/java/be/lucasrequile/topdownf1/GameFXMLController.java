package be.lucasrequile.topdownf1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Car;
import model.GasState;
import model.SteerState;
import model.TrackModel;
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
    
    TrackView trackView;
    
    private boolean isGasPressed = false;
    private boolean isSteered = false;
    
    @FXML
    void initialize() {
        trackModel = new TrackModel(670.7,917.4);
        carModel = new Car(0,0,0,2,5,85,12,-60, -5,GasState.IDLE, SteerState.IDLE);
        
        trackView = new TrackView(trackModel);
        AnchorPane grassPane = new AnchorPane();
        Image forestImg = new Image("grass.png");
        
        for(int i = -2000; i<3000; i=i+288){ //*size nog toevoegen
            for(int j =-2000; j<1500; j=j+160){
                ImageView forest = new ImageView(forestImg);
                forest.setTranslateX(i);
                forest.setTranslateY(j);
                grassPane.getChildren().add(forest);
            }
        }
        
        AnchorPane trackPane = new AnchorPane(grassPane,trackView);
        view = new GameView(carModel, trackPane);
        
        
        gamePane.getChildren().addAll(view);
        
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
            case Z:
                isGasPressed = true;
                carModel.setGasState(GasState.ACCELERATING);
                break;
            case DOWN:
            case S:
                isGasPressed = true;
                carModel.setGasState(GasState.DECELERATING);
                break;
            case RIGHT:
            case D:
                isSteered = true;
                carModel.setSteerState(SteerState.RIGHT);
                break;
            case LEFT:
            case Q:
                isSteered = true;
                carModel.setSteerState(SteerState.LEFT);
                break;
        }
        update();
    }
    public void keyReleased(KeyEvent k){
        switch(k.getCode()){
            case UP:
            case Z:
                isGasPressed = false;
                break;
            case DOWN:
            case S:
                isGasPressed = false;
                break;
            case LEFT:
            case Q:
                isSteered = false;
                break;
            case RIGHT:
            case D:
                isSteered = false;
                break;
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
        trackView.update();
    }
    public boolean isKeyPressed(){
        return isGasPressed;
    }

    private void reset(MouseEvent m) {
        carModel.resetCar();
    }
}
