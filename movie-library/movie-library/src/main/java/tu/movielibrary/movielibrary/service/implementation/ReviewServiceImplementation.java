package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.movielibrary.movielibrary.model.Review;
import tu.movielibrary.movielibrary.model.User;
import tu.movielibrary.movielibrary.repositories.ReviewRepo;
import tu.movielibrary.movielibrary.service.ReviewService;

import java.util.List;


@Service
public class ReviewServiceImplementation implements ReviewService {
    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public void saveNewReview(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public Review getSingleReview(Long id) {
        return reviewRepo.findById(id).orElse(new Review());
    }

    public Review findByReviewId(long reviewId){
        return reviewRepo.findByReviewId(reviewId);
    }


    /*public Review findByComments(String comment){
        return reviewRepo.findByComment(comment);
    }*/

    public List<Review> findByUserId(long userId){
        return reviewRepo.findByUserId(userId);
    }

    public List<Review> findAllByUser(User user){
        return reviewRepo.findAllByUser(user);
    }

}
