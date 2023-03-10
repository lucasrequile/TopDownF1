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
package model;


/**
 *
 * @author Lucas Requilé
 */
public class TrackModel {
    private String trackSVGCode = "m995.23,929.18h-.18s-639.27-1.99-639.27-1.99c-25.2,1.61-42.97-3.78-52.83-16.03-5.54-6.88-6.98-13.9-8.37-20.7-1.19-5.82-2.43-11.85-6.26-19.91v-.02s-.01,0-.02-.01l-.97-2.08c-2.1-4.58-6.81-15.24-8.97-23.11l-.03-.11c-.13-.5-.29-1.02-.47-1.53-.13-.39-.28-.75-.52-1.35-1.15-2.93-3.84-9.81-13.4-36.86-16.42-46.51-25.78-74.51-30.75-89.8-14.54-44.79-28.61-95.28-41.82-150.05l-.08-.37-55.29-273.22c-14.03-35.07-29.88-69.26-47.12-101.65-16.54-31.06-34.44-60.77-59.22-101.88-7.35-12.2-14.84-24.48-22.25-36.49l-.33-.53-.26-.56C-1.51,32.73-2.21,19.32,4.71,9.91c10.41-14.17,30.46-11.79,85.07-1.39,36.1,6.88,54.21,10.33,64.52,13.26,120.25,34.27,303.54,128.7,305.37,129.65,87.04,45,182.58,81.14,283.97,107.42l.7.21c27.79,9.38,46.45,28.7,47.53,49.22,1.19,22.64-17.78,38-37.86,54.25-12.84,10.39-23.6,15.81-39.89,24.02-14.8,7.45-33.2,16.73-59.02,21.75-9.53,1.86-19.13,2.98-28.53,3.33-26.51.99-53.34-4.04-79.74-14.98l-.24-.1-148.18-65.92-.24-.12c-32.93-16.78-71.85-10.76-90.54,14.01-16.33,21.65-10.1,49.96-8.68,55.41l.06.23c24.11,102.95,39.51,152.73,45.37,164.09,2.87,5.57,6.56,10.32,6.59,10.37,5.67,7.25,12.94,13.25,21.61,17.84,9.79,2.14,19.39,2.4,28.57.78,16.44-2.91,27.75-11.24,34.5-16.22l1.1-.81c2.79-2.04,69.15-50.06,139.68-50.91,13.68-.18,27.63,1.49,41.46,4.92l405.55,103.31c26.35,4.59,47.34,15.32,62.38,31.89,24.76,27.28,25.61,61.69,27.02,118.7.68,27.53-.54,55.22-3.62,82.3l-.15,1.3-.47,1.22c-1.52,3.93-3.37,7.75-5.49,11.34-23.83,40.33-77.72,47.94-107.73,48.89h-.18Zm-640.08-22.32h.35s639.44,1.99,639.44,1.99c20.9-.68,71.16-5.85,90.68-38.9,1.34-2.27,2.54-4.67,3.56-7.16,2.87-25.72,3.99-52.01,3.34-78.15-1.44-58.15-2.87-84.73-21.75-105.54-11.99-13.21-29.2-21.82-51.16-25.58l-.79-.17-405.88-103.39c-12.08-3-24.29-4.44-36.26-4.31-64.08.78-127.28,46.52-127.91,46.99l-1.05.77c-7.65,5.64-21.89,16.13-43.01,19.87-12.28,2.18-25.05,1.75-37.96-1.27l-1.2-.28-1.1-.56c-11.82-6.01-21.74-14.09-29.5-24.01-.2-.25-4.86-6.24-8.64-13.57-8.67-16.81-26.27-79.86-47.07-168.66-2.59-10.06-9.16-44.38,12.16-72.64,11.84-15.7,30.07-26.4,51.33-30.15,21.26-3.74,44.13-.14,64.43,10.14l147.58,65.65c23.63,9.77,47.55,14.28,71.07,13.39,8.36-.32,16.9-1.31,25.41-2.97,23.06-4.49,39.37-12.7,53.75-19.95,15.66-7.89,25.11-12.65,36.25-21.67,16.63-13.46,30.99-25.09,30.35-37.37-.62-11.7-14.33-24.38-33.39-30.91-102.72-26.66-199.55-63.31-287.84-108.95-1.82-.94-183.32-94.45-301.61-128.16-9.43-2.69-27.25-6.08-62.75-12.84-19.84-3.78-61.14-11.65-64.89-6.55-1.17,1.59-1.61,7.55,3.98,19.91,7.34,11.9,14.74,24.05,22.02,36.13,24.94,41.38,42.97,71.28,59.75,102.82,17.73,33.3,34.01,68.46,48.4,104.52l.34.85,55.62,274.84c13.08,54.2,26.99,104.12,41.35,148.36,4.93,15.18,14.23,43,30.58,89.31,9.44,26.73,12.14,33.62,13.15,36.21.37.96.59,1.53.8,2.13.34.97.64,1.95.9,2.92,1.79,6.52,6.48,17.16,8.71,21.87l.04.09.06.13.87,1.9c4.14,9.27,5.62,16.52,6.83,22.43,1.24,6.07,1.95,9.12,4.29,12.03,6.86,8.52,23.36,9.3,36,8.47l.35-.02Z";
    private double svgWidth = 1113.04;
    private double svgHeight = 929.18;
    private double xCoStart = 670.7;
    private double yCoStart = 917.4;

    /**
     *
     * @param svgCode svg-pad-string van het circuit-pad
     * @param svgWidth Breedte van de SVG-viewport
     * @param svgHeight Hoogte van de SVG viewport
     * @param xCoStart startcoordinaat van het circuit - x
     * @param yCoStart startcoordinaat van het circuit - y
     */
    public TrackModel(String svgCode, double svgWidth, double svgHeight, double xCoStart, double yCoStart) {
        this.trackSVGCode = svgCode;
        this.svgWidth = svgWidth;
        this.svgHeight = svgHeight;
        this.xCoStart = xCoStart;
        this.yCoStart = yCoStart;
    }
    
    public String getTrackSVGCode() {
        return trackSVGCode;
    }

    public void setTrackSVGCode(String trackSVGCode) {
        this.trackSVGCode = trackSVGCode;
    }

    public double getSvgWidth() {
        return svgWidth;
    }

    public void setSvgWidth(double svgWidth) {
        this.svgWidth = svgWidth;
    }

    public double getSvgHeight() {
        return svgHeight;
    }

    public void setSvgHeight(double svgHeight) {
        this.svgHeight = svgHeight;
    }

    public double getxCoStart() {
        return xCoStart;
    }

    public double getyCoStart() {
        return yCoStart;
    }

    public void setxCoStart(double xCoStart) {
        this.xCoStart = xCoStart;
    }

    public void setyCoStart(double yCoStart) {
        this.yCoStart = yCoStart;
    }
}
