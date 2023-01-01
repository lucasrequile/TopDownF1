package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Car;

/**
 *
 * @author lucas
 */
public class GameView extends Region{
    private Car model;
    private AnchorPane anchorPane;
    private double x;
    private double y;
    public final static int SIZE = 5;
    
    public GameView(Car model) {
        this.model = model;
        anchorPane = new AnchorPane();
        Rectangle rectangle = new Rectangle(0,0,model.getLength()*SIZE,model.getWidth()*SIZE);
        /*Circle circle1 = new Circle(model.getLength()*SIZE-SIZE, model.getWidth()*SIZE/4, SIZE/2,Color.RED);
        Circle circle2 = new Circle(model.getLength()*SIZE-SIZE, model.getWidth()*3*SIZE/4, SIZE/2,Color.RED);*/
        anchorPane.getChildren().addAll(rectangle/*,circle1,circle2*/);
        update();
    }
    public void update(){
        getChildren().clear();
        anchorPane.setTranslateX(model.getX()*SIZE);
        anchorPane.setTranslateY(model.getY()*SIZE);
        anchorPane.setRotate(model.getDegrees());
        getChildren().addAll(anchorPane);
    }

    public static int getSIZE() {
        return SIZE;
    }
    
    
    
}
