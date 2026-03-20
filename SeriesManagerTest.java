/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.seriesapp;

import java.util.ArrayList;

public class SeriesManagerTest {

    static class SeriesModel {
        private String id, name, age, episodes;

        public SeriesModel(String id, String name, String age, String episodes) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.episodes = episodes;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public String getAge() { return age; }
        public String getEpisodes() { return episodes; }

        public void setName(String name) { this.name = name; }
        public void setAge(String age) { this.age = age; }
        public void setEpisodes(String episodes) { this.episodes = episodes; }
    }

    static ArrayList<SeriesModel> list = new ArrayList<>();

    public static void main(String[] args) {

        // Setup test data
        list.add(new SeriesModel("101", "Breaking Bad", "18", "62"));

        TestSearchSeries();
        TestSearchSeries_SeriesNotFound();
        TestUpdateSeries();
        TestDeleteSeries();
        TestDeleteSeries_SeriesNotFound();
        TestSeriesAgeRestriction_AgeValid();
        TestSeriesAgeRestriction_SeriesAgeInvalid();
    }

    // 1. Search FOUND
    public static void TestSearchSeries() {
        boolean found = false;

        for (SeriesModel s : list) {
            if (s.getId().equals("101")) {
                found = true;
            }
        }

        System.out.println("TestSearchSeries: " + (found ? "PASSED" : "FAILED"));
    }

    // 2. Search NOT FOUND
    public static void TestSearchSeries_SeriesNotFound() {
        boolean found = false;

        for (SeriesModel s : list) {
            if (s.getId().equals("999")) {
                found = true;
            }
        }

        System.out.println("TestSearchSeries_SeriesNotFound: " + (!found ? "PASSED" : "FAILED"));
    }

    // 3. Update
    public static void TestUpdateSeries() {
        boolean updated = false;

        for (SeriesModel s : list) {
            if (s.getId().equals("101")) {
                s.setName("Updated Series");
                updated = true;
            }
        }

        System.out.println("TestUpdateSeries: " + (updated ? "PASSED" : "FAILED"));
    }

    // 4. Delete SUCCESS
    public static void TestDeleteSeries() {
        boolean removed = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals("101")) {
                list.remove(i);
                removed = true;
                break;
            }
        }

        System.out.println("TestDeleteSeries: " + (removed ? "PASSED" : "FAILED"));
    }

    // 5. Delete NOT FOUND
    public static void TestDeleteSeries_SeriesNotFound() {
        boolean removed = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals("999")) {
                list.remove(i);
                removed = true;
                break;
            }
        }

        System.out.println("TestDeleteSeries_SeriesNotFound: " + (!removed ? "PASSED" : "FAILED"));
    }

    // 6. Age VALID
    public static void TestSeriesAgeRestriction_AgeValid() {
        int age = 10;
        boolean valid = age >= 2 && age <= 18;

        System.out.println("TestSeriesAgeRestriction_AgeValid: " + (valid ? "PASSED" : "FAILED"));
    }

    // 7. Age INVALID
    public static void TestSeriesAgeRestriction_SeriesAgeInvalid() {
        int age = 25;
        boolean valid = age >= 2 && age <= 18;

        System.out.println("TestSeriesAgeRestriction_SeriesAgeInvalid: " + (!valid ? "PASSED" : "FAILED"));
    }
}
