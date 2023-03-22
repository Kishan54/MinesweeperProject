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

        ArrayList<Plate> plate_array = default_board.create_board(default_board.getBackboard_width(), default_board.getBackboard_length());

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
        System.out.println("The Board: \n");

        int y = 1;
        for (Plate plate : plate_array) {
            if (plate.getPosition_y() == y) {
                System.out.print("");
            } else {
                y += 1;
                System.out.println("");
            }

            if (plate.getState() == 0){
                System.out.print("O");
            } else if (plate.getState() == 9){
                System.out.print("X");
            }
        }
    }
}