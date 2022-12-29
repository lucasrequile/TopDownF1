package be.lucasrequile.topdownf1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
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
    @FXML
    void initialize() {
        model = new Car(0,0,0,10,0);
        view = new GameView(model);
        
        gamePane.getChildren().addAll(view);

        gamePane.setOnKeyPressed(this::move);
        view.setFocusTraversable(true);
        MoveCar moveCarModel = new MoveCar(model,this);
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(moveCarModel, 0, period);
        update();
    }

    public void move(KeyEvent k) {
        switch(k.getCode()){ //switch-case is een snellere manier van een if
            case LEFT:
                model.left();
                break;
            case RIGHT:
                model.right();
                break;
            case UP:
                model.up();
                break;
            case DOWN:
                model.down();
                break;
        }
        update();
    }

    void update() {
        view.update();
    }

    public int getPeriod() {
        return period;
    }
}
