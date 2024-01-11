package tu.movielibrary.movielibrary.service;

import tu.movielibrary.movielibrary.model.Review;

public interface ReviewService {
    public void saveNewReview(Review review);

    public void deleteReview(Long id);

    public Review getSingleReview(Long id);
}
