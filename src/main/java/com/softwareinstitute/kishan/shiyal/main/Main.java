package com.softwareinstitute.kishan.shiyal.main;

import com.softwareinstitute.kishan.shiyal.minesweeper.Backboard;
import com.softwareinstitute.kishan.shiyal.minesweeper.Plate;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        boolean breakingLoop = false;
        int userInput;
        System.out.println("Hello world!");

        //create default board
        Backboard default_board = new Backboard();
        ArrayList<Plate> plate_array = new ArrayList<Plate>();

        default_board.setBackboard_length(5);
        default_board.setBackboard_width(5);
        plate_array = default_board.create_board(default_board.getBackboard_length(), default_board.getBackboard_width());

        do {
            System.out.println("\nPlease choose an option: " +
                    "\n1 - Display Test Board " +
                    "\n2 - Create Game " +
                    "\n3 - Quit " +
                    "\nChoose your option (1-3):");
            userInput = myObj.nextInt();
            if (userInput == 1){
                display_backboard(default_board, plate_array);
            } else if (userInput == 2) {
                continue;
            } else if (userInput == 3) {
                breakingLoop = true;
            }
        } while (breakingLoop == false);
    }

    public static void display_backboard (Backboard default_board, ArrayList<Plate> plate_array){
        System.out.println("All Animals: ");
        for (int i = 0; i< default_board.getBackboard_length(); i++){
            for(int j = 0;j< default_board.getBackboard_width();j++){
                System.out.print("X");
            }
            System.out.println();
        }
        int y = 1;
        for (Plate plate : plate_array) {
            if (plate.getPosition_y() == y) {
                System.out.print(plate.getPosition_x() + " " + plate.getPosition_y() + " - ");
            } else {
                y += 1;
                System.out.print("\n" + plate.getPosition_x() + " " + plate.getPosition_y());
            }

        }
    }
}