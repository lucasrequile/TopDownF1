package view;

import javafx.scene.shape.Rectangle;
import model.TrackModel;
import view.GameView;

/**
 *
 * @author Lucas Requilé
 */
public class TrackView {
    private TrackModel model;
    private GameView gameView;

    public TrackView(TrackModel model) {
        this.model = model;
    }
    
    public void drawRoad(int x,int y){
        Rectangle rectangle= new Rectangle(x, y, 15*gameView.getSIZE(), 15*gameView.getSIZE());
    }
    


}
