package com.softwareinstitute.kishan.shiyal.minesweeper;

public class Backboard {

    /////////////// Attributes //////////////

    private Plate[][] plates = new Plate[0][0];
    int backboard_length;
    int backboard_width;
    int backboard_difficulty;

    /////////////// Constructors //////////////
    public Backboard() { super(); }

    /////////////// Methods //////////////

    public void create_board(int x, int y) {
        for (int i = 1; i < x+1; i++){
            for (int j = 1; j < y+1; j++){
                System.out.print("X");
                Plate new_plate = new Plate();
                new_plate.setPosition_x(x);
                new_plate.setPosition_y(y);
                new_plate.setState(0);
                new_plate.setTouched(false);
            }
            System.out.println();
        }
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

    public Plate[][] getPlates() {
        return plates;
    }

    public void setPlates(Plate[][] plates) {
        this.plates = plates;
    }



}
