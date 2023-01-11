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
package be.lucasrequile.topdownf1;

import java.util.TimerTask;
import javafx.application.Platform;
import model.Car;
import model.GameModel;

/**
 *
 * @author Lucas Requilé
 */
public class CarTimer extends TimerTask {
    private Car model;
    private GameModel gameModel;
    private GameFXMLController controller;

    public CarTimer(Car model, GameModel gameModel, GameFXMLController controller) {
        this.model = model;
        this.gameModel = gameModel;
        this.controller = controller;
    }
    
    public void run(){
        gameModel.updateLaptime();
        Platform.runLater(controller::gasSteerCheck);
        model.position();
        Platform.runLater(controller::update);
    }
}
