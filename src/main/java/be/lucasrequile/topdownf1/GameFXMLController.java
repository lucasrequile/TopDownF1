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
        model = new Car(0,0,0,0);
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
                break;
            case DOWN:
                isGasPressed = true;
                break;
            case RIGHT:
                model.right();
                break;
            case LEFT:
                model.left();
                break;
        }
        move();
        keyVar = k.getCode();
    }
    public void keyReleased(KeyEvent k){
        switch(k.getCode()){
            case UP:
                isGasPressed = false;
            case DOWN:
                isGasPressed = false;
        }
        move();
        keyVar = k.getCode();
    }
    
    public void move(){
        if(isGasPressed==false){
                model.nothingPressed();
                update();
        }
        else{
            switch(keyVar){
                    case UP:
                        model.accelerate();
                        break;
                    case DOWN:
                        model.decelerate();
                        break;
                }
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
