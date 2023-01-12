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
import model.PrimaryModel;

/**
 * Timer-klasse voor PrimaryController
 * @author Lucas Requilé
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
