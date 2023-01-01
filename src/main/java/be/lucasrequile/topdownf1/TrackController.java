package be.lucasrequile.topdownf1;

import model.TrackModel;
import view.TrackView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.util.HashSet;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Lucas Requilé
 */
public class TrackController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane trackPane;
    
    TrackModel model;
    TrackView view;
    
    @FXML
    void initialize() {
        model = new TrackModel(0,0);
        view = new TrackView(model);
        
        trackPane.getChildren().addAll(view);
        trackPane.setOnKeyPressed(this::move);

        view.setFocusTraversable(true);
    }
        public void move(KeyEvent k) {
        switch(k.getCode()){
            case UP:
                model.up();
                break;
            case DOWN:
                model.down();
                break;
            case RIGHT:
                model.right();
                break;
            case LEFT:
                model.left();
                break;
        }
        update();
    }
    public void update() {
        view.update();
    }
}
