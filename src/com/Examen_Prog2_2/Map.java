package com.Examen_Prog2_2;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<NaturalPark> parks;
    private List<Hotel> hotels;

    public Map() {
        this.parks = new ArrayList<>();
        this.hotels = new ArrayList<>();
    }

    public void addPark(NaturalPark park) {
        parks.add(park);
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public List<Review> getAllReviews() {
        List<Review> allReviews = new ArrayList<>();
        for (NaturalPark park : parks) {
            allReviews.addAll(park.getAllReviews());
        }
        for (Hotel hotel : hotels) {
            allReviews.addAll(hotel.getAllReviews());
            for (Room room : hotel.getRooms()) {
                allReviews.addAll(room.getAllReviews());
            }
        }
        return allReviews;
    }

    public Hotel findBestHotel() {
        Hotel bestHotel = null;
        int maxNearbyParks = 0;

        for (Hotel hotel : hotels) {
            int nearbyParksCount = 0;
            for (NaturalPark park : parks) {
                if (park.getNearbyHotels().contains(hotel)) {
                    nearbyParksCount++;
                }
            }
            if (nearbyParksCount > maxNearbyParks) {
                maxNearbyParks = nearbyParksCount;
                bestHotel = hotel;
            } else if (nearbyParksCount == maxNearbyParks) {
                if (Math.random() < 0.5) {
                    bestHotel = hotel;
                }
            }
        }

        return bestHotel;
    }

    public List<Place> getAllPlacesInside(double minLat, double maxLat, double minLong, double maxLong) {
        List<Place> placesInside = new ArrayList<>();
        for (NaturalPark park : parks) {
            if (isWithinBounds(park, minLat, maxLat, minLong, maxLong)) {
                placesInside.add(park);
            }
        }
        for (Hotel hotel : hotels) {
            if (isWithinBounds(hotel, minLat, maxLat, minLong, maxLong)) {
                placesInside.add(hotel);
            }
        }
        return placesInside;
    }

    private boolean isWithinBounds(Place place, double minLat, double maxLat, double minLong, double maxLong) {
        return place.getLatitude() >= minLat && place.getLatitude() <= maxLat &&
                place.getLongitude() >= minLong && place.getLongitude() <= maxLong;
    }

    public double findCheapestHotelPrice(List<NaturalPark> parksToVisit) {
        double totalCost = 0;
        for (NaturalPark park : parksToVisit) {
            double minPrice = Double.MAX_VALUE;
            for (Hotel hotel : park.getNearbyHotels()) {
                for (Room room : hotel.getRooms()) {
                    if (room.getPricePerNight() < minPrice) {
                        minPrice = room.getPricePerNight();
                    }
                }
            }
            totalCost += minPrice;
        }
        return totalCost;
    }

    public List<Reviewable> getAllReviewedItems() {
        List<Reviewable> reviewedItems = new ArrayList<>();
        for (NaturalPark park : parks) {
            if (!park.getAllReviews().isEmpty()) {
                reviewedItems.add(park);
            }
        }
        for (Hotel hotel : hotels) {
            if (!hotel.getAllReviews().isEmpty()) {
                reviewedItems.add(hotel);
            }
            for (Room room : hotel.getRooms()) {
                if (!room.getAllReviews().isEmpty()) {
                    reviewedItems.add(room);
                }
            }
        }
        return reviewedItems;
    }

    @Override
    public String toString() {
        return "Map{" +
                "parks=" + parks +
                ", hotels=" + hotels +
                '}';
    }
}

