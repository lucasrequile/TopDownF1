package be.lucasrequile.topdownf1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Car;
import model.Direction;
import view.GameView;

public class GameFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorpane;

    Car model;
    GameView view;
    @FXML
    void initialize() {
        model = new Car(0,0,Direction.RIGHT);
        view = new GameView(model);
        
        anchorpane.getChildren().add(view);

        anchorpane.setOnKeyPressed(this::move);
    }

    private void move(KeyEvent k) {
        switch(k.getCode()){ //switch-case is een snellere manier van een if
            case LEFT:
                model.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                model.setDirection(Direction.RIGHT);
                break;
            case UP:
                model.setDirection(Direction.UP);
                break;
            case DOWN:
                model.setDirection(Direction.DOWN);
                break;
        }
    }

    void update() {
        view.update();
    }

}
