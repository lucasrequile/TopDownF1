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

import javafx.scene.image.Image;
import model.CarEnum;

/**
 *PrimaryModel is een Model-klasse die in het leven is geroepen om te kunnen wisselen tussen 2 FXML-files en controllers, zonder data te verliezen.
 * 
 * @author Lucas Requilé
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
    private TrackModel trackModel;
    private String svgCode;
    private Image img;
    
    
    public PrimaryModel() {
        car = new Car(0,0,180, width, length, topSpeed, acceleration, deceleration, bulgeOutDeceleration, GasState.IDLE, SteerState.IDLE);
        gameModel = new GameModel(car);
        trackModel = new TrackModel(svgCode, 0, 0, 0,0);
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
                topSpeed = 70;
                acceleration = 7;
                deceleration = -40;
                bulgeOutDeceleration = -5;
                img = new Image("BMWM8.png");
                
        }
        car.setWidth(width);
        car.setLength(length);
        car.setTopSpeed(topSpeed);
        car.setAcceleration(acceleration);
        car.setDeceleration(deceleration);
        car.setBulgeOutDeceleration(bulgeOutDeceleration);
        car.setImg(img);
}
    public void trackChoice(TrackEnum track){
        if(track == TrackEnum.AUSTRIA){
            trackModel.setTrackSVGCode("m995.23,929.18h-.18s-639.27-1.99-639.27-1.99c-25.2,1.61-42.97-3.78-52.83-16.03-5.54-6.88-6.98-13.9-8.37-20.7-1.19-5.82-2.43-11.85-6.26-19.91v-.02s-.01,0-.02-.01l-.97-2.08c-2.1-4.58-6.81-15.24-8.97-23.11l-.03-.11c-.13-.5-.29-1.02-.47-1.53-.13-.39-.28-.75-.52-1.35-1.15-2.93-3.84-9.81-13.4-36.86-16.42-46.51-25.78-74.51-30.75-89.8-14.54-44.79-28.61-95.28-41.82-150.05l-.08-.37-55.29-273.22c-14.03-35.07-29.88-69.26-47.12-101.65-16.54-31.06-34.44-60.77-59.22-101.88-7.35-12.2-14.84-24.48-22.25-36.49l-.33-.53-.26-.56C-1.51,32.73-2.21,19.32,4.71,9.91c10.41-14.17,30.46-11.79,85.07-1.39,36.1,6.88,54.21,10.33,64.52,13.26,120.25,34.27,303.54,128.7,305.37,129.65,87.04,45,182.58,81.14,283.97,107.42l.7.21c27.79,9.38,46.45,28.7,47.53,49.22,1.19,22.64-17.78,38-37.86,54.25-12.84,10.39-23.6,15.81-39.89,24.02-14.8,7.45-33.2,16.73-59.02,21.75-9.53,1.86-19.13,2.98-28.53,3.33-26.51.99-53.34-4.04-79.74-14.98l-.24-.1-148.18-65.92-.24-.12c-32.93-16.78-71.85-10.76-90.54,14.01-16.33,21.65-10.1,49.96-8.68,55.41l.06.23c24.11,102.95,39.51,152.73,45.37,164.09,2.87,5.57,6.56,10.32,6.59,10.37,5.67,7.25,12.94,13.25,21.61,17.84,9.79,2.14,19.39,2.4,28.57.78,16.44-2.91,27.75-11.24,34.5-16.22l1.1-.81c2.79-2.04,69.15-50.06,139.68-50.91,13.68-.18,27.63,1.49,41.46,4.92l405.55,103.31c26.35,4.59,47.34,15.32,62.38,31.89,24.76,27.28,25.61,61.69,27.02,118.7.68,27.53-.54,55.22-3.62,82.3l-.15,1.3-.47,1.22c-1.52,3.93-3.37,7.75-5.49,11.34-23.83,40.33-77.72,47.94-107.73,48.89h-.18Zm-640.08-22.32h.35s639.44,1.99,639.44,1.99c20.9-.68,71.16-5.85,90.68-38.9,1.34-2.27,2.54-4.67,3.56-7.16,2.87-25.72,3.99-52.01,3.34-78.15-1.44-58.15-2.87-84.73-21.75-105.54-11.99-13.21-29.2-21.82-51.16-25.58l-.79-.17-405.88-103.39c-12.08-3-24.29-4.44-36.26-4.31-64.08.78-127.28,46.52-127.91,46.99l-1.05.77c-7.65,5.64-21.89,16.13-43.01,19.87-12.28,2.18-25.05,1.75-37.96-1.27l-1.2-.28-1.1-.56c-11.82-6.01-21.74-14.09-29.5-24.01-.2-.25-4.86-6.24-8.64-13.57-8.67-16.81-26.27-79.86-47.07-168.66-2.59-10.06-9.16-44.38,12.16-72.64,11.84-15.7,30.07-26.4,51.33-30.15,21.26-3.74,44.13-.14,64.43,10.14l147.58,65.65c23.63,9.77,47.55,14.28,71.07,13.39,8.36-.32,16.9-1.31,25.41-2.97,23.06-4.49,39.37-12.7,53.75-19.95,15.66-7.89,25.11-12.65,36.25-21.67,16.63-13.46,30.99-25.09,30.35-37.37-.62-11.7-14.33-24.38-33.39-30.91-102.72-26.66-199.55-63.31-287.84-108.95-1.82-.94-183.32-94.45-301.61-128.16-9.43-2.69-27.25-6.08-62.75-12.84-19.84-3.78-61.14-11.65-64.89-6.55-1.17,1.59-1.61,7.55,3.98,19.91,7.34,11.9,14.74,24.05,22.02,36.13,24.94,41.38,42.97,71.28,59.75,102.82,17.73,33.3,34.01,68.46,48.4,104.52l.34.85,55.62,274.84c13.08,54.2,26.99,104.12,41.35,148.36,4.93,15.18,14.23,43,30.58,89.31,9.44,26.73,12.14,33.62,13.15,36.21.37.96.59,1.53.8,2.13.34.97.64,1.95.9,2.92,1.79,6.52,6.48,17.16,8.71,21.87l.04.09.06.13.87,1.9c4.14,9.27,5.62,16.52,6.83,22.43,1.24,6.07,1.95,9.12,4.29,12.03,6.86,8.52,23.36,9.3,36,8.47l.35-.02Z");
            trackModel.setSvgHeight(929.18);
            trackModel.setSvgWidth(1113.04);
            trackModel.setxCoStart(670.7);
            trackModel.setyCoStart(917.4);
        }
        if(track == TrackEnum.SPA){
            trackModel.setTrackSVGCode("M1730.167 1232c-15.997 0 -29.543 -2.681 -41.109 -5.523 -54.125 -13.296 -109.86 -43.09 -180.742 -96.584 -44.64 -33.685 -67.04 -50.593 -87.87 -73.443 -33.325 -36.547 -50.773 -68.821 -67.641 -100.035 -20.299 -37.547 -39.468 -73.013 -85.339 -111.561 -11.845 -9.955 -25.502 -19.929 -39.478 -28.853 -30.724 -19.609 -50.713 -26.312 -194.428 -65.19 -11.255 -3.041 -30.104 -8.144 -53.414 -4.542 -19.409 3.001 -32.875 10.485 -41.779 15.447l-0.18 0.1c-18.739 10.425 -38.027 20.429 -56.676 30.104 -23.121 11.995 -47.031 24.401 -69.872 37.597 -53.534 30.924 -75.644 43.61 -85.299 47.201 -24.551 9.124 -40.979 11.705 -65.85 15.627 -13.786 2.171 -29.403 4.632 -50.643 8.824 -31.884 6.293 -64.089 14.136 -95.714 23.291l-0.86 0.21c-7.303 1.431 -29.533 5.773 -39.468 -7.683 -3.882 -5.252 -5.132 -11.975 -3.722 -19.969 2.481 -14.036 -1.161 -23.651 -4.532 -25.992 -0.43 -0.3 -0.91 -0.63 -2.311 0.09L51.724 1187.75c-6.663 5.673 -28.403 22.37 -42.95 12.636 -14.096 -9.424 -8.464 -33.535 -2.071 -55.405 24.371 -83.428 59.727 -153.76 85.089 -198.07 27.533 -48.092 49.032 -76.105 49.933 -77.275a1036.301 1036.301 0 0 1 29.403 -36.377l0.12 -0.14 165.615 -188.416c8.954 -29.103 23.191 -53.985 42.339 -73.974 23.08 -24.111 43.83 -31.044 67.861 -39.078 13.246 -4.432 28.253 -9.454 46.091 -18.158 34.996 -17.098 50.883 -33.645 74.934 -58.707 21.61 -22.52 48.512 -50.553 99.555 -90.381 22.47 -17.538 45.711 -34.306 69.071 -49.833l0.69 -0.46 0.76 -0.34 657.839 -293.854a194.778 194.778 0 0 1 39.328 -14.276c20.889 -5.132 34.686 -8.514 49.563 -2.241 7.083 2.981 10.065 6.403 15.007 12.055 3.332 3.802 7.884 9.014 16.147 17.098 10.195 9.955 18.238 17.818 22.18 18.658 4.122 0.88 6.803 -0.08 18.678 -5.402 4.182 -1.871 9.384 -4.202 15.777 -6.833 6.973 -2.871 17.108 -6.353 37.287 -13.306 37.687 -12.966 54.855 -18.879 69.532 -16.618 26.352 4.052 42.139 25.131 51.563 37.717l0.55 0.73c49.983 66.64 169.517 186.235 170.718 187.435l0.5 0.5 0.43 0.57c0.33 0.44 8.114 10.925 12.015 25.662 5.422 20.469 1.07 39.298 -12.586 54.465 -8.974 9.975 -19.519 16.347 -31.344 18.939 -24.611 5.402 -43.89 -11.485 -64.299 -29.373l-1.141 -1c-10.965 -9.604 -16.518 -16.207 -31.334 -33.855 -6.313 -7.513 -14.176 -16.878 -24.921 -29.413 -19.759 -23.05 -22.97 -26.102 -25.191 -27.222 -27.232 -13.726 -70.612 14.727 -84.869 24.081l-1.701 1.111c-60.578 39.508 -161.613 76.935 -300.307 111.251l-0.75 0.16c-15.577 2.611 -68.341 14.687 -93.022 60.167 -11.585 21.35 -12.286 40.929 -12.896 58.206 -1.811 50.773 12.206 90.951 41.649 119.404 15.217 14.697 34.776 25.872 56.556 32.305l281.768 75.734c5.412 1.05 50.443 10.795 69.201 46.721 11.885 22.77 10.505 50.413 -4.112 82.167 -10.595 23.02 -12.866 43.24 -6.753 60.107 4.022 11.095 11.145 21.67 62.018 47.892 35.176 18.128 72.383 34.326 110.56 48.142 15.187 5.012 42.069 17.508 52.614 45.101 3.742 9.784 6.383 25.952 -6.553 64.439 -14.407 42.869 -26.842 79.896 -65.22 108.9 -31.214 23.591 -63.439 29.483 -75.844 30.924 -5.843 0.68 -11.395 0.97 -16.688 0.97ZM996.303 725.02c18.588 0 33.465 4.022 42.489 6.463 146.367 39.598 166.926 46.551 199.971 67.641 14.697 9.384 29.073 19.899 41.579 30.404 48.792 40.999 68.841 78.096 90.071 117.373 16.297 30.154 33.155 61.338 64.829 96.074 19.579 21.48 41.489 38.017 85.139 70.952 68.611 51.784 122.106 80.507 173.469 93.122 13.646 3.352 30.344 6.473 50.713 4.112 10.775 -1.251 38.798 -6.383 66.08 -27.002 33.445 -25.281 44.42 -57.946 58.317 -99.315 12.306 -36.617 8.184 -47.382 6.833 -50.923 -7.914 -20.679 -30.834 -30.164 -40.318 -33.285l-0.28 -0.1c-39.038 -14.116 -77.075 -30.684 -113.061 -49.222 -47.442 -24.441 -64.179 -38.197 -71.673 -58.857 -7.974 -21.99 -5.482 -47.332 7.393 -75.294 11.865 -25.782 13.416 -47.472 4.592 -64.449 -14.917 -28.723 -55.125 -36.397 -55.525 -36.467l-0.81 -0.18 -282.488 -75.925c-24.911 -7.333 -47.362 -20.179 -64.92 -37.137 -21.62 -20.889 -36.166 -47.642 -43.23 -79.496 -5.583 -25.161 -4.832 -46.071 -4.512 -55.005 0.62 -17.538 1.481 -41.549 15.307 -67.04 28.793 -53.064 88.6 -67.171 106.909 -70.292 136.332 -33.755 235.177 -70.262 293.814 -108.499l1.661 -1.08c18.408 -12.075 67.301 -44.14 104.848 -25.221 5.723 2.881 8.814 5.743 31.374 32.065 10.815 12.616 18.709 22.02 25.051 29.573 14.497 17.268 19.389 23.08 29.193 31.674l1.141 1c17.218 15.077 32.075 28.113 46.831 24.871 7.653 -1.681 14.637 -5.983 20.759 -12.776 20.339 -22.6 2.731 -50.013 -0.22 -54.245 -10.195 -10.205 -122.446 -122.926 -171.998 -189.006l-0.56 -0.74c-8.094 -10.805 -20.319 -27.122 -38.598 -29.944 -9.794 -1.511 -27.603 4.622 -59.927 15.747 -19.869 6.833 -29.814 10.265 -36.236 12.906 -6.113 2.511 -10.945 4.682 -15.217 6.593 -12.576 5.633 -20.169 9.044 -31.054 6.713 -9.594 -2.051 -17.548 -9.814 -31.975 -23.911 -8.834 -8.634 -13.886 -14.417 -17.238 -18.238 -4.332 -4.962 -4.992 -5.643 -7.724 -6.783 -8.434 -3.552 -16.928 -1.691 -37.017 3.241 -12.236 3.001 -24.161 7.343 -35.436 12.886l-0.34 0.16 -657.239 293.584c-22.71 15.117 -45.291 31.424 -67.151 48.482 -49.903 38.958 -76.255 66.41 -97.424 88.47 -24.611 25.642 -42.399 44.18 -80.587 62.829 -19.019 9.294 -34.696 14.537 -48.522 19.159 -23.271 7.784 -40.088 13.406 -59.757 33.945 -17.388 18.158 -30.254 41.019 -38.247 67.961l-0.63 2.111 -168.447 191.627c-9.774 11.535 -19.449 23.511 -28.773 35.596 -0.85 1.111 -86.109 112.851 -131.66 268.732 -6.403 21.91 -6.293 29.924 -5.663 32.735 3.892 -0.69 12.436 -5.633 18.678 -10.965l0.4 -0.33 412.768 -317.624 0.53 -0.31c8.124 -4.792 16.988 -4.622 24.321 0.47 11.335 7.864 16.367 25.882 12.836 45.911 -0.5 2.841 -0.14 4.252 0.12 4.602 0.03 0.03 3.362 3.031 19.099 0.01 32.035 -9.264 64.659 -17.198 96.964 -23.581 21.62 -4.272 38.137 -6.873 51.403 -8.964 24.521 -3.862 39.318 -6.193 61.988 -14.617 8.464 -3.141 36.246 -19.189 82.257 -45.771 23.231 -13.416 47.352 -25.932 70.672 -38.027 18.528 -9.614 37.687 -19.549 56.166 -29.824l0.18 -0.1c9.534 -5.302 25.502 -14.186 48.452 -17.728 6.743 -1.04 13.176 -1.471 19.209 -1.471Z");
            trackModel.setSvgHeight(1232);
            trackModel.setSvgWidth(1917.57);
            trackModel.setxCoStart(257.4);
            trackModel.setyCoStart(995.10);
        }
        if(track == TrackEnum.NURBURGRING){
            trackModel.setTrackSVGCode("m1749.75,1015.1c-18.29,0-37.17-6.49-53.21-18.28l-198.39-147.76-347.37-237.66-.74-.78-116.07-122.71-.43-.62c-1.47-2.11-8.54-13.17-3.38-23.5,2.35-4.72,7.96-10.45,21.28-10.95,41.14-1.55,76.24,10.78,77.71,11.31l.15.05c4.91,1.84,9.97,3.86,14.87,5.82,17.38,6.94,35.35,14.11,51.86,15.56,2.34.21,5.96.4,10.41-.27,13.27-2,22.14-9.93,25.47-12.92,5.96-5.33,10.73-12.16,14.18-20.28,7.1-16.7-12.24-70.14-28.24-102.76l-.34-.76c-.22-.57-23.45-57.4-51.52-48.92-16.09,4.85-22.06,9.42-24.23,12.39-1.85,2.53-1.8,5.12-1.53,10.27.07,1.31.14,2.66.16,4.08.15,10.82,2.88,37,3.3,40.98.49,2.5,1.21,8.77-1.79,15.74-4.29,9.94-15.27,16.68-32.62,20.03-31,5.99-81.76.96-102.58-1.55l-123.3-5.12-212.58-36.35c-.43-.1-44.97-10.07-61.87,18.22-6.22,10.42-9.41,17.61-24.21,59.38-5.52,15.59-11.29,31.21-17.13,46.42l-.17.42c-.84,1.93-9.05,18.96-36.43,22.28-2.06.25-4.05.36-5.98.36-23.59,0-37.46-17.3-38.78-19.02l-74.46-96.19c-39.29-45.34-82.87-83.32-129.52-112.89-58.41-37.02-130.15-66.32-146.16-72.14-1.5-.54-6.88-2.54-13.75-5.5-24.86-10.71-38.55-16.61-48.51-29.68-9.97-13.08-18.13-35.18-8.35-54.41,4.17-8.19,13.33-18.96,33.34-23.76,27.45-6.6,49.9,10.19,54.98,14.4l163.62,115.79c15.5,10.92,30.71,21.95,45.2,32.78l2.86,2.14c12.62,9.45,17.84,13.37,26.74,16.3,6.93,2.29,15.98,4.11,35.06,2.03,24.58-2.69,49.52-10.09,74.12-21.99,12.48-6.56,25.64-11.08,39.11-13.45,33.33-5.85,60.81,3.02,69.84,5.93l.87.28c35.68,11.43,133.01,29.45,306.3,56.72l.13.02c15.55,2.66,31.13,4.16,46.31,4.46,10.44.2,15.92-.22,20.77-3.3,6.17-3.91,8.95-10.53,10.45-14.08,18.43-43.88,30.42-85.37,30.54-85.78,11.59-40.31,14.65-45.2,18.7-49.83,17.79-20.34,48.84-30.7,77.25-25.76,16.08,2.79,27.28,10,30.96,12.37l.1.06c46.25,29.77,94.61,58.12,141.37,85.53,47.82,28.04,97.27,57.03,144.71,87.66l.1.06c3.1,2,11.32,7.31,20.8,16.01,12.5,11.47,23.11,25.11,31.54,40.52l.39.79c86.54,198.08,151.35,334.72,165.26,355.23,4.51.2,8.49-.3,10.17-.56,10.01-4.01,19.65-4.87,28.68-2.58,17.84,4.54,26.91,19.99,38.38,39.57,15.47,26.39,23.24,39.63,29.08,51.62,27.29,55.98,39.09,95.23,43.7,113.64,1.32,5.27,2.56,10.63,3.7,15.91l.14.65.05.66c.74,9.27.74,32.65-15.32,49.6-10.98,11.59-27.15,18-45.52,18.06h-.24Zm-585.9-419.01l345.93,236.67.16.12,198.51,147.84c27.62,20.32,58.58,17.26,72.52,2.55,10.2-10.76,10.42-26.62,9.95-33.59-1.05-4.86-2.2-9.76-3.41-14.6-4.42-17.65-15.78-55.38-42.27-109.72-5.51-11.3-13.14-24.31-28.35-50.25-11.59-19.78-17.19-28.05-26.05-30.3-5.03-1.28-10.78-.58-17.07,2.08l-.95.4-1.01.2c-1.04.2-10.47,1.96-20.86.62-7.37-.96-11.96-9.13-24.16-32.64-9.2-17.73-21.57-43.06-36.77-75.29-31.77-67.37-73.15-159.14-116.53-258.43-7.34-13.33-16.52-25.1-27.3-35-8.23-7.55-15.42-12.19-18.12-13.94l-.1-.06c-47.07-30.4-96.33-59.28-143.97-87.21-46.94-27.52-95.47-55.97-142.08-85.97l-.1-.07c-3.14-2.02-11.47-7.38-23.54-9.48-21.45-3.72-45.6,4.18-58.75,19.22-1.86,2.13-4.92,8.72-14.53,42.18-.5,1.74-12.44,43.04-31.32,88-2.01,4.78-6.7,15.96-18.19,23.23-9.95,6.31-20.33,6.63-31.89,6.41-16.16-.31-32.73-1.91-49.23-4.73-174.29-27.43-272.54-45.68-309.23-57.42l-.91-.29c-8.69-2.8-31.78-10.26-60.22-5.26-11.48,2.02-22.71,5.89-33.4,11.53l-.3.15c-26.72,12.94-53.91,21-80.82,23.94-18.25,2-31.26,1.12-43.51-2.92-12.01-3.96-19.28-9.41-32.48-19.29l-2.85-2.13c-14.34-10.72-29.4-21.64-44.76-32.46l-164.32-116.29-.33-.28c-3.01-2.55-18.97-15.02-37.72-10.51-10.1,2.43-16.89,6.93-20.17,13.38-5.98,11.75,1.59,26.85,6.43,33.2,6.78,8.89,17.35,13.45,40.51,23.43,6.37,2.75,11.29,4.57,12.65,5.06,20.21,7.34,91.13,36.7,150.06,74.05,48.38,30.67,93.5,70,134.12,116.91l.35.43,74.75,96.57c.36.46,10.16,12.85,26.4,10.88,14.87-1.8,19.76-9.2,20.51-10.5,5.72-14.9,11.36-30.18,16.76-45.44,15.4-43.45,18.86-51.18,25.89-62.95,23.74-39.75,78.02-28.71,83.34-27.52l210.42,35.96,122.8,5.1.39.05c15.32,1.85,67.56,7.45,96.77,1.81,11.64-2.25,16.99-5.88,18.04-8.31.75-1.74.61-3.39.54-3.86l-.27-.85.05-.45c-.13-1.25-3.29-30.76-3.46-43.35-.01-1.03-.07-2.14-.13-3.31-.84-15.99,1.58-31.29,39.98-42.88,44.88-13.55,73.17,53.86,75.8,60.39,1.44,2.97,10.84,22.55,19.04,45.56,12.49,35.06,15.59,59.1,9.48,73.49-4.61,10.85-11.09,20.05-19.25,27.36-4.12,3.69-16.66,14.92-35.85,17.81-6.56.99-11.79.71-15.15.41-19.45-1.71-38.81-9.44-57.53-16.91-4.98-1.99-9.69-3.87-14.37-5.62-1.43-.5-33.66-11.53-70.17-10.14-1.61.06-2.75.23-3.51.4.25.69.62,1.48,1.02,2.16l114.15,120.68Zm-614.65-119.79s0,0,0,0c0,0,0,0,0,0Zm574.9-104.83h0s0,0,0,0Z");
            trackModel.setSvgHeight(923);
            trackModel.setSvgWidth(1750);
            trackModel.setxCoStart(1477.8);
            trackModel.setyCoStart(774.5+2*26);
        }
    }

    public Car getCar() {
        return car;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public TrackModel getTrackModel() {
        return trackModel;
    }
}
