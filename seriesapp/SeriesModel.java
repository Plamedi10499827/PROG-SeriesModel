/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seriesapp;

/**
 *
 * @author Student
 */
public class SeriesModel {

    private String id;
    private String name;
    private String age;
    private String episodes;

    // Constructor
    public SeriesModel(String id, String name, String age, String episodes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.episodes = episodes;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }
}