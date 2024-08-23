package com.Examen_Prog2_2;

import java.util.ArrayList;
import java.util.List;

public class Hotel extends Place implements Reviewable {
    private String telephone;
    private String email;
    private List<Room> rooms;
    private List<Review> reviews;

    public Hotel(String name, double latitude, double longitude, String description, String telephone, String email) {
        super(name, latitude, longitude, description);
        this.telephone = telephone;
        this.email = email;
        this.rooms = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
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
    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", rooms=" + rooms +
                ", reviews=" + reviews +
                '}';
    }
}

