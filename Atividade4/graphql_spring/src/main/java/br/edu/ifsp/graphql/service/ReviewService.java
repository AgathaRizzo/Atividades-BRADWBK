package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;

public class ReviewService {
    public Review createReview(Episode episode, ReviewInput reviewInput) {
        return new Review(reviewInput.getStars(), reviewInput.getCommentary());
    }
}
