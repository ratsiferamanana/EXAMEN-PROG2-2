package com.Examen_Prog2_2;

import java.util.List;

public interface Reviewable {
    void addReview(Review review);
    List<Review> getAllReviews();
}

