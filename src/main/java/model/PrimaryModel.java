package model;

import javafx.scene.image.Image;
import model.CarEnum;

/**
 *
 * @author lucas
 */
public class PrimaryModel {
    private CarEnum carModel;
    private Car car;
    private int width = 2;
    private int length = 5;
    private double topSpeed = 85;
    private double acceleration = 12;
    private double deceleration = -60;
    private double bulgeOutDeceleration = -5;
    private GameModel gameModel;
    private Image img;
    
    
    public PrimaryModel() {
        car = new Car(0,0,180, width, length, topSpeed, acceleration, deceleration, bulgeOutDeceleration, GasState.IDLE, SteerState.IDLE);
        gameModel = new GameModel(car);
    }
    
    public void carChoice(CarEnum carModel){
        if(carModel==CarEnum.FERRARIF1){
                width = 2;
                length = 5;
                topSpeed = 85;
                acceleration = 12;
                deceleration = -60;
                bulgeOutDeceleration = -5;
                img = new Image("ferrariF1.png");
        }
        if(carModel==CarEnum.REDBULLF1){
                width = 2;
                length = 5;
                topSpeed = 85;
                acceleration = 12;
                deceleration = -60;
                bulgeOutDeceleration = -5;
                img = new Image("redbullcar.png");
            
        }
        if(carModel==CarEnum.BMWROADCAR){
                width = 2;
                length = 5;
                topSpeed = 75;
                acceleration = 7;
                deceleration = -40;
                bulgeOutDeceleration = -5;
                img = new Image("car1.png");
                
        }
        car.setWidth(width);
        car.setLength(length);
        car.setTopSpeed(topSpeed);
        car.setAcceleration(acceleration);
        car.setDeceleration(deceleration);
        car.setBulgeOutDeceleration(bulgeOutDeceleration);
        car.setImg(img);
}

    public Car getCar() {
        return car;
    }

    public GameModel getGameModel() {
        return gameModel;
    }
    
        
}
