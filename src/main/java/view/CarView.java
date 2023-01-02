package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Car;

/**
 *
 * @author lucas
 */
public class CarView extends Region{
    private Car model;
    private GameView gameView;
    private AnchorPane anchorPane;
    private double x;
    private double y;
    private int size = gameView.getSIZE();
    
    public CarView(Car model) {
        this.model = model;
        anchorPane = new AnchorPane();
        Rectangle rectangle = new Rectangle(0,0,model.getLength()*size,model.getWidth()*size);
        rectangle.setFill(Color.GREEN);
        anchorPane.getChildren().addAll(rectangle/*,circle1,circle2*/);
        update();
    }
    public void update(){
        getChildren().clear();
        anchorPane.setTranslateX(model.getX()*size);
        anchorPane.setTranslateY(model.getY()*size);
        anchorPane.setRotate(model.getDegrees());
        getChildren().addAll(anchorPane);
    }
}
