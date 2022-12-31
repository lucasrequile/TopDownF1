/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.TrackView;

/**
 *
 * @author Lucas Requilé
 */
public class TrackModel {
    private int[][] trackLayout;
    TrackView view;

    public TrackModel(int[][] trackLayout) {
        this.trackLayout = trackLayout;
    }
    
    public void drawTrack(){
        for(int i = 0; i < trackLayout.length; i++){
            for(int j = 0; j < trackLayout[i].length; j++){
                if(trackLayout[i][j]==1){
                    view.drawRoad(i,j);
                }
            }
        }
    }
    public int[][] getTrackLayout() {
        return trackLayout;
    }

    public void setTrackLayout(int[][] trackLayout) {
        this.trackLayout = trackLayout;
    }
    
}
