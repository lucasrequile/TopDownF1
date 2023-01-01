package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.StrokeType;
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

        SVGPath svgTrack = new SVGPath();
        svgTrack.setContent(model.getTrackSVGCode());
        svgTrack.setFill(Color.BLACK);
        svgTrack.setStrokeType(StrokeType.OUTSIDE);
        svgTrack.setStroke(Color.RED);
        svgTrack.setStrokeWidth(3);
        
        /*svgTrack.setLayoutX(565);
        svgTrack.setLayoutY(465);*/
        
        svgTrack.setScaleX(SIZE);
        svgTrack.setScaleY(SIZE);
        
        anchorPane.getChildren().addAll(svgTrack);

        
        update();
    }

    public void update(){
        getChildren().clear();
        anchorPane.setTranslateX(model.getX()*SIZE);
        anchorPane.setTranslateY(model.getY()*SIZE);
        getChildren().addAll(anchorPane);
    }
}
