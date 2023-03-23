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

        int inputLength;
        int inputWidth;

        System.out.println("Enter length: ");
        inputLength = myObj.nextInt();
        System.out.println("Enter width: ");
        inputWidth = myObj.nextInt();

        default_board.setBackboard_length(inputLength);
        default_board.setBackboard_width(inputWidth);

        ArrayList<Plate> initial_plate_array = default_board.create_board(default_board.getBackboard_width(), default_board.getBackboard_length());
        ArrayList<Plate> plate_array = default_board.check_board(initial_plate_array, default_board.getBackboard_width(), default_board.getBackboard_length() );
        System.out.println(initial_plate_array);
        System.out.println(plate_array);
        for (Plate plate : plate_array) {
            System.out.println(plate.getState());
        }
        do {
            System.out.println("\nPlease choose an option: " +
                    "\n1 - Display Test Board " +
                    "\n2 - Create Game " +
                    "\n3 - Quit " +
                    "\nChoose your option (1-3):");
            userInput = myObj.nextInt();
            if (userInput == 1){
                play_game(default_board, plate_array);
            } else if (userInput == 2) {
                continue;
            } else if (userInput == 3) {
                breakingLoop = true;
            }
        } while (breakingLoop == false);
    }

    public static void play_game(Backboard default_board, ArrayList<Plate> plate_array){
        boolean game_finished = false;
        Scanner myObj = new Scanner(System.in);
        do {
            int enter_x;
            int enter_y;

            System.out.println("Enter x coord: ");
            enter_x = myObj.nextInt();
            System.out.println("Enter y coord: ");
            enter_y = myObj.nextInt();
            for (Plate plate : plate_array) {
                if (plate.getPosition_x() == enter_x && plate.getPosition_y() == enter_y){
                    if (plate.getState() == 9) {
                        game_finished = true;
                    }
                    plate.setTouched(true);
                } else {
                    continue;
                }
            }
            display_backboard(default_board, plate_array);
        } while (game_finished == false);

        System.out.println("\nOh no you clicked the mine! GAME OVER");
    }

    public static void display_backboard (Backboard default_board, ArrayList<Plate> plate_array){
        System.out.println("The Board: \n");

        int y = 1;
        for (Plate plate : plate_array) {
            if (plate.getPosition_y() == y) {
                System.out.print("");
            } else {
                y += 1;
                System.out.println("");
            }
            if (plate.isTouched()){
                if (plate.getState() == 0){
                    System.out.print("O");
                } else if (plate.getState() >= 1 && plate.getState() <= 8) {
                    System.out.print(plate.getState());
                } else if (plate.getState() == 9){
                    System.out.print("X");
                }
            } else {
                System.out.print("-");
            }

        }
    }
}