package com.softwareinstitute.kishan.shiyal.minesweeper;

import java.util.ArrayList;
import java.util.Random;

public class Backboard {

    /////////////// Attributes //////////////

    //private Plate[][] plates = new Plate[0][0];
    int backboard_length;
    int backboard_width;
    int backboard_difficulty;

    /////////////// Constructors //////////////
    public Backboard() { super(); }

    /////////////// Methods //////////////

    public ArrayList<Plate> create_board(int x, int y) {
        ArrayList<Plate> plates = new ArrayList<>();
        for (int i = 1; i < x+1; i++){
            for (int j = 1; j < y+1; j++){
                Plate new_plate = new Plate();
                new_plate.setPosition_x(j);
                new_plate.setPosition_y(i);
                new_plate.setTouched(false);
                // 0 if blank, 9 if mine
                double randomNumber = Math.random();
                // mine should be 15% of the game
                if (randomNumber <= 0.15) {
                    new_plate.setState(9);
                } else {
                    new_plate.setState(0);
                }
                plates.add(new_plate);
            }
        }

//        int index;
//        for (int i = 1; i < x+1; i++){
//            for (int j = 1; j < y+1; j++){
//                Plate current_plate = new Plate();
//                index = (((i-1)*x)+j)-1;
//                current_plate = plates.;
//
//            }
//        }
        return plates;
    }

    public int getBackboard_length() {
        return backboard_length;
    }

    public void setBackboard_length(int backboard_length) {
        this.backboard_length = backboard_length;
    }

    public int getBackboard_width() {
        return backboard_width;
    }

    public void setBackboard_width(int backboard_width) {
        this.backboard_width = backboard_width;
    }

    public int getBackboard_difficulty() {
        return backboard_difficulty;
    }

    public void setBackboard_difficulty(int backboard_difficulty) {
        this.backboard_difficulty = backboard_difficulty;
    }

//    public Plate[][] getPlates() {
//        return plates;
//    }
//
//    public void setPlates(Plate[][] plates) {
//        this.plates = plates;
//    }



}
