package com.softwareinstitute.kishan.shiyal.minesweeper;

public class Plates{

    /////////////// Attributes //////////////
    int state;
    boolean touched;

    /////////////// Constructors //////////////
    public Plates() { super(); }

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

}
