package com.softwareinstitute.kishan.shiyal.minesweeper;

import java.util.ArrayList;

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
//                current_plate = plates.get;
//
//            }
//        }
        return plates;
    }

    public ArrayList<Plate> check_board(ArrayList<Plate> plate_array, int x, int y) {
        ArrayList<Plate> plates = new ArrayList<>();

        for (Plate plate : plate_array) {
            int display_number = 0;
            int plate_x = plate.getPosition_x();
            int plate_y = plate.getPosition_y();
            if (plate_x == 1 && plate_y == 1) {
                //top left corner
                // check right, bottom right, bottom
                display_number += check_board_right(plate, plate_array, x);
                display_number += check_board_bottomright(plate, plate_array, x);
                display_number += check_board_bottom(plate, plate_array, x);
                if (plate.getState() == 9) {
                    System.out.print("");
                } else {
                    plate.setState(display_number);
                }

            } else if (plate_x == x && plate_y == 1) {
                //top right corner
                // check left, bottom left, bottom
                display_number += check_board_left(plate, plate_array, x);
                display_number += check_board_bottomleft(plate, plate_array, x);
                display_number += check_board_bottom(plate, plate_array, x);
                if (plate.getState() == 9) {
                    System.out.print("");
                } else {
                    plate.setState(display_number);
                }
            } else if (plate_x == 1 && plate_y == y) {
                //bottom left corner
                // check top, top right, right
                display_number += check_board_top(plate, plate_array, x);
                display_number += check_board_topright(plate, plate_array, x);
                display_number += check_board_right(plate, plate_array, x);
                if (plate.getState() == 9) {
                    System.out.print("");
                } else {
                    plate.setState(display_number);
                }
            } else if (plate_x == x && plate_y == y) {
                //bottom right corner
                // check top, top left, left
                display_number += check_board_top(plate, plate_array, x);
                display_number += check_board_topleft(plate, plate_array, x);
                display_number += check_board_left(plate, plate_array, x);
                if (plate.getState() == 9) {
                    System.out.print("");
                } else {
                    plate.setState(display_number);
                }
            } else if (plate_y == 1) {
                //top row
                display_number += check_board_left(plate, plate_array, x);
                display_number += check_board_bottomleft(plate, plate_array, x);
                display_number += check_board_bottom(plate, plate_array, x);
                display_number += check_board_bottomright(plate, plate_array, x);
                display_number += check_board_right(plate, plate_array, x);
                if (plate.getState() == 9) {
                    System.out.print("");
                } else {
                    plate.setState(display_number);
                }
            } else if (plate_y == y) {
                //bottom row
                display_number += check_board_left(plate, plate_array, x);
                display_number += check_board_topleft(plate, plate_array, x);
                display_number += check_board_top(plate, plate_array, x);
                display_number += check_board_topright(plate, plate_array, x);
                display_number += check_board_right(plate, plate_array, x);
                if (plate.getState() == 9) {
                    System.out.print("");
                } else {
                    plate.setState(display_number);
                }
            } else if (plate_x == 1) {
                //left column
                display_number += check_board_top(plate, plate_array, x);
                display_number += check_board_topright(plate, plate_array, x);
                display_number += check_board_right(plate, plate_array, x);
                display_number += check_board_bottomright(plate, plate_array, x);
                display_number += check_board_bottom(plate, plate_array, x);
                if (plate.getState() == 9) {
                    System.out.print("");
                } else {
                    plate.setState(display_number);
                }
            } else if (plate_x == x) {
                //right column
                display_number += check_board_top(plate, plate_array, x);
                display_number += check_board_topleft(plate, plate_array, x);
                display_number += check_board_left(plate, plate_array, x);
                display_number += check_board_bottomleft(plate, plate_array, x);
                display_number += check_board_bottom(plate, plate_array, x);
                if (plate.getState() == 9) {
                    System.out.print("");
                } else {
                    plate.setState(display_number);
                }
            } else {
                //check all surroundings
                display_number += check_board_top(plate, plate_array, x);
                display_number += check_board_topleft(plate, plate_array, x);
                display_number += check_board_left(plate, plate_array, x);
                display_number += check_board_bottomleft(plate, plate_array, x);
                display_number += check_board_bottom(plate, plate_array, x);
                display_number += check_board_bottomright(plate, plate_array, x);
                display_number += check_board_right(plate, plate_array, x);
                display_number += check_board_topright(plate, plate_array, x);
                if (plate.getState() == 9) {
                    System.out.print("");
                } else {
                    plate.setState(display_number);
                }
            }
        }
        plates = plate_array;
        return plates;
    }

    public int check_board_topleft(Plate plate, ArrayList<Plate> plate_array, int x) {
        Plate topleft = plate_array.get(((x*(plate.getPosition_y()-1))+plate.getPosition_x()-x-2));
        if (topleft.getState() == 9) {
            return 1;
        } else {
            return 0;
        }
    }

    public int check_board_top(Plate plate, ArrayList<Plate> plate_array, int x) {
        Plate top = plate_array.get(((x*(plate.getPosition_y()-1))+plate.getPosition_x()-x-1));
        if (top.getState() == 9) {
            return 1;
        } else {
            return 0;
        }
    }
    public int check_board_topright(Plate plate, ArrayList<Plate> plate_array, int x) {
        Plate topright = plate_array.get(((x*(plate.getPosition_y()-1))+plate.getPosition_x()-x));
        if (topright.getState() == 9) {
            return 1;
        } else {
            return 0;
        }
    }

    public int check_board_left(Plate plate, ArrayList<Plate> plate_array, int x) {
        Plate left = plate_array.get(((x*(plate.getPosition_y()-1))+plate.getPosition_x()-2));
        if (left.getState() == 9) {
            return 1;
        } else {
            return 0;
        }
    }

    public int check_board_right(Plate plate, ArrayList<Plate> plate_array, int x) {
        Plate right = plate_array.get(((x*(plate.getPosition_y()-1))+plate.getPosition_x()));
        if (right.getState() == 9) {
            return 1;
        } else {
            return 0;
        }
    }

    public int check_board_bottomleft(Plate plate, ArrayList<Plate> plate_array, int x) {
        Plate bottomleft = plate_array.get(((x*(plate.getPosition_y()-1))+plate.getPosition_x()+x-2));
        if (bottomleft.getState() == 9) {
            return 1;
        } else {
            return 0;
        }
    }

    public int check_board_bottom(Plate plate, ArrayList<Plate> plate_array, int x) {
        Plate bottom = plate_array.get(((x*(plate.getPosition_y()-1))+plate.getPosition_x()+x-1));
        if (bottom.getState() == 9) {
            return 1;
        } else {
            return 0;
        }
    }

    public int check_board_bottomright(Plate plate, ArrayList<Plate> plate_array, int x) {
        Plate bottomright = plate_array.get(((x*(plate.getPosition_y()-1))+plate.getPosition_x()+x));
        if (bottomright.getState() == 9) {
            return 1;
        } else {
            return 0;
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

//    public Plate[][] getPlates() {
//        return plates;
//    }
//
//    public void setPlates(Plate[][] plates) {
//        this.plates = plates;
//    }



}
