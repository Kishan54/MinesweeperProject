package com.softwareinstitute.kishan.shiyal.minesweeper;

public class Plate {

    /////////////// Attributes //////////////
    int state;
    boolean touched;
    int position_x;
    int position_y;

    /////////////// Constructors //////////////
    public Plate() { super(); }

    /////////////// Methods //////////////

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

}
