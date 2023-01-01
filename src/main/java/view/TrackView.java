package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.TrackModel;
import view.GameView;

/**
 *
 * @author Lucas Requilé
 */
public class TrackView extends Region{
    private TrackModel model;
    private GameView gameView;
    private AnchorPane anchorPane;
    public final static int SIZE = 5;

    public TrackView(TrackModel model) {
        this.model = model;
        anchorPane = new AnchorPane();
        update();
    }
    
    public void drawRoad(int x,int y){
        Rectangle rectangle = new Rectangle(x*SIZE, y*SIZE, SIZE,SIZE);
        rectangle.setFill(Color.BLACK);
        anchorPane.getChildren().addAll(rectangle);
    }
    public void drawGrass(int x,int y){
        Rectangle rectangle = new Rectangle(x*SIZE, y*SIZE, SIZE,SIZE);
        rectangle.setFill(Color.GREEN);
        anchorPane.getChildren().addAll(rectangle);
    }
    public void drawBorder(int x,int y){
        Rectangle rectangle = new Rectangle(x*SIZE, y*SIZE, SIZE,SIZE);
        rectangle.setFill(Color.RED);
        anchorPane.getChildren().addAll(rectangle);
    }
    
    public void update(){
        getChildren().addAll(anchorPane);
    }
}
