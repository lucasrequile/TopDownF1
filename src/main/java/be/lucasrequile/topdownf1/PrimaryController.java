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
    private ImageView carImageView;
    
    PrimaryModel model;
    Car carModel;
    GameModel gameModel;

    @FXML
    void initialize() {
        model = new PrimaryModel();
        
        primaryButton.setOnAction(event -> openLayout2());
        
        carModelChoiceBox.getItems().addAll("Ferrari F1 car", "RedBull F1 car", "BMW Road car");
        carModelChoiceBox.setValue("Choose car");
        
        trackChoiceBox.getItems().addAll("Redbull Ring, Austria","Spa-Francorchamps, Belgium");
        trackChoiceBox.setValue("Choose track");
        
        PrimaryChecker checker = new PrimaryChecker(model,this);
        
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(checker, 0, 20);
        update();
    }
    
    public void update(){
        Object carChoice = carModelChoiceBox.getSelectionModel().getSelectedItem();
        if(carChoice.equals("choose car")){
            
        }
        if(carChoice.equals("Ferrari F1 car")){
            model.carChoice(CarEnum.FERRARIF1);
        }if(carChoice.equals("RedBull F1 car")){
            model.carChoice(CarEnum.REDBULLF1);
        }if(carChoice.equals("BMW Road car")){
            model.carChoice(CarEnum.BMWROADCAR);
        }
        speedText.setText(model.getCar().getTopSpeed()*3.6 + " km/h");
        double accelerationSeconds = (double)Math.round((100/3.6)/model.getCar().getAcceleration()*10)/10;
        double decelerationSeconds = (double)Math.round((100/3.6)/-model.getCar().getDeceleration()*10)/10;
        accelerationText.setText(model.getCar().getAcceleration() + " m/s²    -    0-100 km/h in " + accelerationSeconds + "s");
        brakeText.setText(model.getCar().getDeceleration() + " m/s²   -    100-0 km/h in " + decelerationSeconds + "s" );
        carImageView.setImage(model.getCar().getImg());
        
        
        Object trackChoice = trackChoiceBox.getSelectionModel().getSelectedItem();
        if(trackChoice.equals("Redbull Ring, Austria")){
            model.trackChoice(TrackEnum.AUSTRIA);
        }
        if(trackChoice.equals("Spa-Francorchamps, Belgium")){
            model.trackChoice(TrackEnum.SPA);
        }
    }

    public PrimaryModel getModel() {
        return model;
    }
}