package com.Examen_Prog2_2;

import java.util.ArrayList;
import java.util.List;

public class NaturalPark extends Place implements Reviewable {
    private List<Hotel> nearbyHotels;
    private List<Review> reviews;

    public NaturalPark(String name, double latitude, double longitude, String description) {
        super(name, latitude, longitude, description);
        this.nearbyHotels = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public void addNearbyHotel(Hotel hotel) {
        nearbyHotels.add(hotel);
    }

    public List<Hotel> getNearbyHotels() {
        return nearbyHotels;
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "NaturalPark{" +
                "nearbyHotels=" + nearbyHotels +
                ", reviews=" + reviews +
                '}';
    }
}

