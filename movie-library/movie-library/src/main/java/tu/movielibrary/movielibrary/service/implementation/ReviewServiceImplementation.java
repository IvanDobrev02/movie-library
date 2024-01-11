package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.movielibrary.dao.ReviewDao;
import tu.movielibrary.model.Review;
import tu.movielibrary.model.User;
import tu.movielibrary.service.ReviewService;

import java.util.List;


@Service
public class ReviewServiceImplementation implements ReviewService {
    @Autowired
    ReviewDao reviewdao;

    @Override
    public void saveNewReview(Review review) {
        reviewdao.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewdao.deleteById(id);
    }

    @Override
    public Review getSingleReview(Long id) {
        return reviewdao.findById(id).orElse(new Review());
    }

    public Review findByReviewId(long reviewId){
        return reviewdao.findByReviewId(reviewId);
    }


    /*public Review findByComments(String comment){
        return reviewdao.findByComment(comment);
    }*/

    public List<Review> findByUserId(long userId){
        return reviewdao.findByUserId(userId);
    }

    public List<Review> findAllByUser(User user){
        return reviewdao.findAllByUser(user);
    }

}
