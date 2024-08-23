package com.Examen_Prog2_2;

import java.util.ArrayList;
import java.util.List;

public class Room implements Reviewable {
    private int number;
    private double pricePerNight;
    private List<Review> reviews;

    public Room(int number, double pricePerNight) {
        this.number = number;
        this.pricePerNight = pricePerNight;
        this.reviews = new ArrayList<>();
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviews;
    }

    // Getters and setters
    public int getNumber() {
        return number;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", pricePerNight=" + pricePerNight +
                ", reviews=" + reviews +
                '}';
    }
}

