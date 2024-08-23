package com.Examen_Prog2_2;

import java.time.LocalDate;

public class Review {
    private String user;
    private String email;
    private int rating; // Rating out of 5
    private String comment;
    private LocalDate date;

    public Review(String user, String email, int rating, String comment, LocalDate date) {
        this.user = user;
        this.email = email;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    // Getters and setters
    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
