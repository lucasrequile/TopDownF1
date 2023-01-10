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
import javafx.scene.text.Text;
import model.Car;
import model.GameModel;
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
    
    @FXML
    private AnchorPane specPane;

    @FXML
    private Text lapTimeText;

    @FXML
    private Text speedText;

    @FXML
    private Text staticTextLapTime;

    @FXML
    private Text staticTextSpeed;
    
    @FXML
    private Text staticTextLap;
    
    @FXML
    private Text lapText;
    
    TrackModel trackModel;
    Car carModel;
    GameModel gameModel;
    GameView view;
    
    TrackView trackView;
    
    private boolean isGasPressed = false;
    private boolean isSteered = false;
    private int size;
    
    @FXML
    void initialize() {
        trackModel = new TrackModel(670.7,917.4);
        carModel = new Car(0,0,180,2,5,85,12,-60, -5,GasState.IDLE, SteerState.IDLE);
        gameModel = new GameModel(carModel);
        
        trackView = new TrackView(trackModel);
        AnchorPane grassPane = new AnchorPane();
        Image forestImg = new Image("grass.png");
        
        for(int i = -5000; i<5000; i=i+288){ //*size nog toevoegen
            for(int j =-7000; j<1500; j=j+160){
                ImageView forest = new ImageView(forestImg);
                forest.setTranslateX(i);
                forest.setTranslateY(j);
                grassPane.getChildren().add(forest);
            }
        }
        
        AnchorPane trackPane = new AnchorPane(grassPane,trackView);
        view = new GameView(carModel, trackPane);
        
        
        gamePane.getChildren().addAll(view, specPane);
        
        gamePane.setOnKeyPressed(this::keyPressed);
        gamePane.setOnMouseClicked(this::reset);
        gamePane.setOnKeyReleased(this::keyReleased);
        view.setFocusTraversable(true);
        CarTimer moveCarModel = new CarTimer(carModel,gameModel,this);
        
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
        lapTimeText.setText(gameModel.timeToString());
        lapText.setText(gameModel.getLaps() +"");
        speedText.setText(Math.round(carModel.getSpeed()*3.6) + " km/h");
        view.update();
        trackView.update();
    }
    public boolean isKeyPressed(){
        return isGasPressed;
    }

    private void reset(MouseEvent m) {
        carModel.resetCar();
        gameModel.resetLaptime();
    }
}
