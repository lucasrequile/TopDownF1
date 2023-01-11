/*
 * Copyright (C) 2023 Lucas Requilé
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package be.lucasrequile.topdownf1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Car;
import model.GameModel;
import model.GasState;
import model.PrimaryModel;
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
    
    @FXML
    private Text staticTextBestLap;
     
    @FXML
    private Text bestLapTimeText;
    
    private PrimaryModel primaryModel;
    private TrackModel trackModel;
    private Car carModel;
    private GameModel gameModel;
    private GameView view;
    
    private TrackView trackView;
    
    private boolean isGasPressed = false;
    private boolean isSteered = false;
    private int size;
    private final PrimaryController primaryController;
    private Stage stage;
    
    public GameFXMLController(PrimaryController primaryController) {
        // We received the first controller, now let's make it usable throughout this controller.
        this.primaryController = primaryController;
        primaryModel = primaryController.getModel();

        // Create the new stage
        stage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gameFXML.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the Scene
            stage.setScene(new Scene(loader.load(), 1920, 1080));
            stage.setFullScreen(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showStage() {
        stage.showAndWait();
    }

    @FXML
    void initialize() {
        carModel = primaryModel.getCar();
        gameModel = primaryModel.getGameModel();
        trackModel = primaryModel.getTrackModel();
        
        trackView = new TrackView(trackModel);
        
        AnchorPane grassPane = new AnchorPane();
        Image forestImg = new Image("grass.png");
        int grassScale = 2;
        for(int i = -(int)trackModel.getSvgWidth()*6; i<(int)trackModel.getSvgWidth()*6; i=i+288*grassScale){ //*size nog toevoegen
            for(int j =-(int)trackModel.getSvgHeight()*6; j<(int)trackModel.getSvgHeight()*6; j=j+160*grassScale){
                ImageView forest = new ImageView(forestImg);
                forest.setFitWidth(288*grassScale);
                forest.setFitHeight(160*grassScale);
                forest.setTranslateX(i);
                forest.setTranslateY(j);
                grassPane.getChildren().add(forest);
            }
        }
        AnchorPane trackPane = new AnchorPane(grassPane,trackView);
        
        Image img = primaryModel.getCar().getImg();
        view = new GameView(carModel, trackPane, img);
        
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
        lapTimeText.setText(gameModel.timeToString(gameModel.getLaptime()));
        lapText.setText(gameModel.getLaps() +"");
        bestLapTimeText.setText(gameModel.timeToString(gameModel.getBestLap()));
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
