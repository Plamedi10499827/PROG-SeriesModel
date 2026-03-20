/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seriesapp;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class SeriesApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SeriesManager manager = new SeriesManager();

        System.out.println("....LATEST SERIES....");
        System.out.print("Press (1) for MENU or any other key to exit: ");

        String start = sc.nextLine();

        if (!start.equals("1")) {
            System.out.println("Application closed.");
            return;
        }

        int option = 0;

        while (option != 6) {
            System.out.println("\n====MENU====");
            System.out.println("1. Capture a new series");
            System.out.println("2. Search for a series");
            System.out.println("3. Update series age restriction");
            System.out.println("4. Delete a series");
            System.out.println("5. Print series report");
            System.out.println("6. Exit Aplication");

            String input = sc.nextLine();

            if (!input.matches("[0-9]+")) {
                System.out.println("Enter a correct number.");
                continue;
            }

            option = Integer.parseInt(input);

            switch (option) {
                case 1:
                    manager.captureSeries();
                    break;
                case 2:
                    manager.searchSeries();
                    break;
                case 3:
                    manager.updateSeries();
                    break;
                case 4:
                    manager.deleteSeries();
                    break;
                case 5:
                    manager.printReport();
                    break;
                case 6:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Option Invalid .");
            }
        }
    }
}