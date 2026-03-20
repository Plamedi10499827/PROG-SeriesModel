/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seriesapp;

/**
 *
 * @author Student
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SeriesManager {

    private ArrayList<SeriesModel> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Capture
    public void captureSeries() {

        System.out.println("\n--- Add New Series ---");

        System.out.print("Enter series id: ");
        String id = sc.nextLine();

        System.out.print("Enter series name: ");
        String name = sc.nextLine();

        String age = "";
        while (true) {
            System.out.print("Enter age restriction (2-18): ");
            String input = sc.nextLine();

            if (!input.matches("[0-9]+")) {
                System.out.println("Numbers only!");
                continue;
            }

            int a = Integer.parseInt(input);
            if (a >= 2 && a <= 18) {
                age = input;
                break;
            } else {
                System.out.println("Age must be between 2 and 18.");
            }
        }

        String episodes = "";
        while (true) {
            System.out.print("Enter number of episodes: ");
            String ep = sc.nextLine();

            if (!ep.matches("[0-9]+")) {
                System.out.println("Numbers only!");
            } else {
                episodes = ep;
                break;
            }
        }

        list.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series added successfully!");
    }

    // Search
    public void searchSeries() {
        System.out.print("\nEnter series id: ");
        String id = sc.nextLine();

        for (SeriesModel s : list) {
            if (s.getId().equals(id)) {
                System.out.println("\n--- Series Found ---");
                System.out.println("ID: " + s.getId());
                System.out.println("Name: " + s.getName());
                System.out.println("Age: " + s.getAge());
                System.out.println("Episodes: " + s.getEpisodes());
                return;
            }
        }

        System.out.println("Series not found.");
    }

    // Update
    public void updateSeries() {
        System.out.print("\nEnter series id: ");
        String id = sc.nextLine();

        for (SeriesModel s : list) {
            if (s.getId().equals(id)) {

                System.out.print("New name: ");
                s.setName(sc.nextLine());

                while (true) {
                    System.out.print("New age (2-18): ");
                    String input = sc.nextLine();

                    if (!input.matches("[0-9]+")) {
                        System.out.println("Numbers only!");
                        continue;
                    }

                    int a = Integer.parseInt(input);
                    if (a >= 2 && a <= 18) {
                        s.setAge(input);
                        break;
                    } else {
                        System.out.println("Age must be between 2 and 18.");
                    }
                }

                while (true) {
                    System.out.print("New episodes: ");
                    String ep = sc.nextLine();

                    if (!ep.matches("[0-9]+")) {
                        System.out.println("Numbers only!");
                    } else {
                        s.setEpisodes(ep);
                        break;
                    }
                }

                System.out.println("Series updated.");
                return;
            }
        }

        System.out.println("Series not found.");
    }

    // Delete
    public void deleteSeries() {
        System.out.print("\nEnter series id: ");
        String id = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {

                System.out.print("Confirm delete (y/n): ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("y")) {
                    list.remove(i);
                    System.out.println("Series deleted.");
                } else {
                    System.out.println("Delete cancelled.");
                }
                return;
            }
        }

        System.out.println("Series not found.");
    }

    // Report
    public void printReport() {

        if (list.isEmpty()) {
            System.out.println("\nNo series available.");
            return;
        }

        System.out.println("\n===== SERIES REPORT =====");

        int count = 1;
        for (SeriesModel s : list) {
            System.out.println("\nSeries " + count);
            System.out.println("ID: " + s.getId());
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());
            System.out.println("Episodes: " + s.getEpisodes());
            count++;
        }
    }
}
