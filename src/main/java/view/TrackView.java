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

    public TrackView(TrackModel model) {
        this.model = model;
        anchorPane = new AnchorPane();
        Rectangle rectangle = new Rectangle(1,1,10,10);
        anchorPane.getChildren().addAll(rectangle);
        update();
    }
    
    public void drawRoad(int x,int y){
        Rectangle rectangle = new Rectangle(x, y, 1,1);
        rectangle.setFill(Color.BLACK);
        anchorPane.getChildren().addAll(rectangle);
    }
    public void drawGrass(int x,int y){
        Rectangle rectangle = new Rectangle(x, y, 1,1);
        rectangle.setFill(Color.GREEN);
        anchorPane.getChildren().addAll(rectangle);
    }
    public void drawBorder(int x,int y){
        Rectangle rectangle = new Rectangle(x, y, 1,1);
        rectangle.setFill(Color.RED);
        anchorPane.getChildren().addAll(rectangle);
    }
    
    public void update(){
        getChildren().addAll(anchorPane);
    }
}
