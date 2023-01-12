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
    private SVGPath svgTrack;

    public TrackView(TrackModel model) {
        this.model = model;
        anchorPane = new AnchorPane();

        //Maak svg-pad aan, voeg toe aan anchorpane en schaal
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
        double startPointX = model.getxCoStart();
        double startPointY = model.getyCoStart();
        double trackWidth = 26;
        //teken de start/finish lijn
        Line startline = new Line(startPointX+trackWidth,startPointY-trackWidth/2+3,startPointX+trackWidth,startPointY+trackWidth/2-3);
        startline.setStroke(Color.WHITE);
        startline.setStrokeWidth(3);
        startline.setStrokeLineCap(StrokeLineCap.BUTT);
        startline.getStrokeDashArray().add(3.0);
        
        anchorPane.getChildren().add(startline);
        anchorPane.setTranslateX(translateScaleVarX-startPointX*size);
        anchorPane.setTranslateY(translateScaleVarY-(startPointY-trackWidth)*size);
        
        //zet in het midden vh scherm.
        double middenX = 1920/2;
        double middenY = 1080/2;
        anchorPane.setTranslateX(anchorPane.getTranslateX() + middenX - trackWidth*size);
        anchorPane.setTranslateY(anchorPane.getTranslateY() + middenY - trackWidth*size);
        
        getChildren().addAll(anchorPane);
        
        update();
    }

    public void update(){
    }
}
