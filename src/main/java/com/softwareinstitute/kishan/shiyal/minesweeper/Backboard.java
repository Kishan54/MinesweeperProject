package com.softwareinstitute.kishan.shiyal.minesweeper;

public class Backboard {

    /////////////// Attributes //////////////

    private Plates[][] plates = new Plates[0][0];
    int backboard_length;
    int backboard_width;
    int backboard_difficulty;

    /////////////// Constructors //////////////
    public Backboard() { super(); }

    /////////////// Methods //////////////
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



}
