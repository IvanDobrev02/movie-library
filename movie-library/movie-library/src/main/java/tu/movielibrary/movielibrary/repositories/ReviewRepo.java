package tu.movielibrary.movielibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tu.movielibrary.movielibrary.model.Review;
import tu.movielibrary.movielibrary.model.User;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ReviewRepo extends JpaRepository<Review, Long> {

    Review findByReviewId(long reviewId);
    List<Review> findByUserId(long userId);
    List<Review> findAllByUser(User user);
}
