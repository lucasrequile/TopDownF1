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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Car;
import model.PrimaryModel;
import model.CarEnum;
import model.GameModel;
import model.TrackEnum;

public class PrimaryController {
    private final Stage stage;
    public PrimaryController() {
        stage = new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            loader.setController(this);
            stage.setScene(new Scene(loader.load(), 640, 480));
            stage.setTitle("Top-Down F1 - Start settings window");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void showStage() {
        stage.showAndWait();
    }
    private void openLayout2() {
        //nieuwe controller wordt aangemaakt en huidige controller wordt meegegeven
        GameFXMLController controller2 = new GameFXMLController(this);
        controller2.showStage();
        stage.close();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox carModelChoiceBox;
    
    @FXML
    private ChoiceBox trackChoiceBox;

    @FXML
    private Button primaryButton;
    
    @FXML
    private Text speedText;
    
    @FXML
    private Text accelerationText;

    @FXML
    private Text brakeText;
    
    @FXML
    private Text carNameText;
    
    @FXML
    private Text trackInfoText;
    
    
    @FXML
    private Text carCheckText;
    
    @FXML
    private Text trackCheckText;

    @FXML
    private ImageView carImageView;
    
    @FXML
    private ImageView trackImageView;
    
    private PrimaryModel model;
    private Car carModel;
    private GameModel gameModel;
    private Timer primaryTimer;
    private boolean trackChosen = false;
    private boolean carChosen = false;

    @FXML
    void initialize() {
        model = new PrimaryModel();
        
        primaryButton.setOnAction(this::buttonClick);
        
        for(CarEnum car: CarEnum.values()){
            carModelChoiceBox.getItems().add(car);
        }
        carModelChoiceBox.setValue("Choose car");
        
        for(TrackEnum track: TrackEnum.values()){
            trackChoiceBox.getItems().add(track);
        }
        //trackChoiceBox.getItems().addAll(TrackEnum.values()); Zou ook zo kunnen, maar is netbeans niet gelukkig mee
        trackChoiceBox.setValue("Choose track");
        
        PrimaryChecker checker = new PrimaryChecker(model,this);
        
        primaryTimer = new Timer(true);
        primaryTimer.scheduleAtFixedRate(checker, 0, 20);
        update();
    }
    
    public void update(){
        Object carChoice = carModelChoiceBox.getSelectionModel().getSelectedItem();
        if(carChoice.equals("Choose car")){
            carNameText.setText("No car selected");
            carChosen = false;
        }else{
            CarEnum car = CarEnum.valueOf(carChoice.toString());
            model.carChoice(car);
            carChosen = true;
            carNameText.setText(car.getName());
        }
        
        speedText.setText(model.getCar().getTopSpeed()*3.6 + " km/h");
        double accelerationSeconds = (double)Math.round((100/3.6)/model.getCar().getAcceleration()*10)/10;
        double decelerationSeconds = (double)Math.round((100/3.6)/-model.getCar().getDeceleration()*10)/10;
        accelerationText.setText(model.getCar().getAcceleration() + " m/s²    -    0-100 km/h in " + accelerationSeconds + "s");
        brakeText.setText(model.getCar().getDeceleration() + " m/s²   -    100-0 km/h in " + decelerationSeconds + "s" );
        carImageView.setImage(model.getCar().getImg());
        
        Object trackChoice = trackChoiceBox.getSelectionModel().getSelectedItem();
        if(trackChoice.equals("Choose track")){
            trackChosen = false;
        }
        else{
            TrackEnum track = TrackEnum.valueOf(trackChoice.toString());
            trackChosen = true;
            model.trackChoice(track);
            trackInfoText.setText(track.getName() + "\nLength: " + track.getLength() + "\nCorners: " + track.getCorners());
            trackImageView.setImage(track.getImg());
        }
    }
    public void buttonClick(ActionEvent e){
        if(carChosen == true){
            carCheckText.setText("");
            if(trackChosen == true){
                trackCheckText.setText("");
                primaryTimer.cancel();
                openLayout2();
            }
            else{
                trackCheckText.setText("<-- Please select a track.");
            }
        }
        else{
            carCheckText.setText("<-- Please select a car.");
        }
    }
    public PrimaryModel getModel() {
        return model;
    }
}