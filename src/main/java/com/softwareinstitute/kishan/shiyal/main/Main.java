package com.softwareinstitute.kishan.shiyal.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        boolean breakingLoop = false;
        int userInput;
        System.out.println("Hello world!");

        //create default board

        do {
            System.out.println("\nPlease choose an option: " +
                    "\n1 - Display Test Board " +
                    "\n2 - Create Game " +
                    "\n3 - Quit " +
                    "\nChoose your option (1-3):");
            userInput = myObj.nextInt();
            if (userInput == 1){
                displayAnimals(animals);
            } else if (userInput == 2) {
                addAnimal(animals, myObj);
            } else if (userInput == 3) {
                breakingLoop = true;
            }
        } while (breakingLoop == false);
    }

    public static void displayAnimals (ArrayList<Animal> animals){
        System.out.println("All Animals: ");
        if (animals.size() == 0) {
            System.out.println("No Animals");
        } else {
            for (Animal animal : animals){
                System.out.println("\nAnimal: " + animal.getClass().getSimpleName() +
                        "\nName: " + animal.getName() +
                        "\nAge: " + animal.getAge());
            }
        }
    }
}