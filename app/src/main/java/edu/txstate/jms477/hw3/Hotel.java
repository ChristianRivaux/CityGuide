package edu.txstate.jms477.hw3;

import java.text.DecimalFormat;

public class Hotel { //might need to make cost string, then convert to decimal later
    public Hotel(int id, String name, String city, String state, double cost, int image) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.cost = cost;
        this.image = image;
        this.url = url;
    }

    public Hotel() {
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private int id;
    private String name;
    private String city;
    private String state;
    private double cost;
    private int image;
    private String url;
}
