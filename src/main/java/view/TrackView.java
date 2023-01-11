package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import model.TrackModel;

/**
 *
 * @author Lucas Requilé
 */
public class TrackView extends Region{
    private TrackModel model;
    private AnchorPane anchorPane;
    private GameView gameView;
    private int size = gameView.getSIZE();
    private double actualPointInMetersX;
    private double actualPointInMetersY;
    private SVGPath svgTrack;

    public TrackView(TrackModel model) {
        this.model = model;
        anchorPane = new AnchorPane();

        svgTrack = new SVGPath();
        svgTrack.setContent(model.getTrackSVGCode());
        svgTrack.setFill(Color.BLACK);
        svgTrack.setStrokeType(StrokeType.OUTSIDE);
        svgTrack.setStroke(Color.RED);
        svgTrack.setStrokeWidth(3);

        svgTrack.setLayoutX(0);
        svgTrack.setLayoutY(0);
        
        anchorPane.getChildren().addAll(svgTrack);
        
        anchorPane.setScaleX(size);
        anchorPane.setScaleY(size);
        
        //translateScaleVar houdt na schaling de linkerbovenhoek van het model op de linkerbovenhoek van het scherm 
        double translateScaleVarX = (size-1)*(model.getSvgWidth()/2);
        double translateScaleVarY = (size-1)*(model.getSvgHeight()/2);
        
        anchorPane.setTranslateX(translateScaleVarX);
        anchorPane.setTranslateY(translateScaleVarY);
        
        //Volgende 2 regels bepalen welk deel van de baan er in beeld is.
        //338 is het x coordinaat van het startpunt van de baan
        double startPointX = model.getxCoStart();
        double startPointY = model.getyCoStart();
        double trackWidth = 26;
        Line startline = new Line(startPointX+trackWidth,startPointY-trackWidth/2+3,startPointX+trackWidth,startPointY+trackWidth/2-3);
        startline.setStroke(Color.WHITE);
        startline.setStrokeWidth(3);
        startline.setStrokeLineCap(StrokeLineCap.BUTT);
        startline.getStrokeDashArray().add(3.0);
        
        anchorPane.getChildren().add(startline);
        anchorPane.setTranslateX(translateScaleVarX-startPointX*size);
        //666 is het y coordinaat van de baan, -26 voor de baan (20px, en 2x3pxl voor de rand)
        anchorPane.setTranslateY(translateScaleVarY-(startPointY-trackWidth)*size);
        
        actualPointInMetersX = -(anchorPane.getTranslateX()-translateScaleVarX)/size;
        actualPointInMetersY = -(anchorPane.getTranslateY()-translateScaleVarY)/size+trackWidth;
        
        //zet in het midden vh scherm.
        double middenX = 1920/2;
        double middenY = 1080/2;
        anchorPane.setTranslateX(anchorPane.getTranslateX() + middenX - trackWidth*size);
        anchorPane.setTranslateY(anchorPane.getTranslateY() + middenY - trackWidth*size);
        
        getChildren().addAll(anchorPane);
        
        System.out.println("Actual point in meters: " + actualPointInMetersX + ","+actualPointInMetersY);
        
        update();
    }

    public void update(){
    }
}
