/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.lucasrequile.topdownf1;

import java.util.TimerTask;
import model.PrimaryModel;

/**
 *
 * @author lucas
 */
public class PrimaryChecker extends TimerTask{
    private PrimaryModel model;
    private PrimaryController controller;
            
    public PrimaryChecker(PrimaryModel model, PrimaryController controller) {
        this.model = model;
        this.controller = controller;
    }
    
    public void run(){
        controller.update();
    }
    
}
