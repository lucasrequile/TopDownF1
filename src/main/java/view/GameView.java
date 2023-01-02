/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

/**
 *
 * @author lucas
 */
public class GameView extends Region {
    private AnchorPane anchorPane;
    public final static int SIZE = 5;

    public GameView() {
        anchorPane = new AnchorPane();
    }
    
    public void update(){
    }

    public static int getSIZE() {
        return SIZE;
    }
    
    
    
    
        
    
}
