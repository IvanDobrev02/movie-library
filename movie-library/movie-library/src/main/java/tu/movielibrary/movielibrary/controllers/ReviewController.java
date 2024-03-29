package tu.movielibrary.movielibrary.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tu.movielibrary.movielibrary.model.Review;
import tu.movielibrary.movielibrary.repositories.UserRepo;
import tu.movielibrary.movielibrary.service.implementation.MovieServiceImplementation;
import tu.movielibrary.movielibrary.service.implementation.ReviewServiceImplementation;


@Controller
@RequestMapping("/movies/{movie_id}/review")
public class ReviewController {
    @Autowired
    private ReviewServiceImplementation reviewService;

    @Autowired
    private MovieServiceImplementation movieService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/new/{user_id}")
    public String addNewReview(@PathVariable(value = "movie_id") Long movie_id, @PathVariable(value = "user_id") Long user_id, @ModelAttribute("new_review") Review review) {
        try {
            review.setDateTimeMilli(System.currentTimeMillis());
            review.setMovie(movieService.getMovieById(movie_id));
            review.setUser(userRepo.findById(user_id).orElseThrow());
            reviewService.saveNewReview(review);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/movies/" + movie_id;
    }

    @GetMapping("/edit/{review_id}")
    public String editReviewView(@PathVariable(value = "movie_id") Long movie_id, @PathVariable(value = "review_id") Long review_id, Model model, HttpSession session) {
        try {
            Review review = reviewService.getSingleReview(review_id);
            session.setAttribute("session_review", review);
            model.addAttribute("review", review);
            model.addAttribute("movie", movieService.getMovieById(movie_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/movie/review/edit_review";
    }

    @PostMapping("/edit/")
    public String editReview(@PathVariable(value = "movie_id") Long movie_id, @ModelAttribute("review") Review review, HttpSession session) {
        Review temp_review = (Review) session.getAttribute("session_review");
        review.setReviewId(temp_review.getReviewId());
        review.setUser(temp_review.getUser());
        review.setDateTimeMilli(temp_review.getDateTimeMilli());
        review.setLikes(temp_review.getLikes());
        review.setMovie(temp_review.getMovie());

        reviewService.saveNewReview(review);
        return "redirect:/movies/" + movie_id;
    }

    @GetMapping("/delete/{review_id}")
    public String deleteReview(@PathVariable(value = "movie_id") Long movie_id, @PathVariable(value = "review_id") Long review_id) {
        reviewService.deleteReview(review_id);
        return "redirect:/movies/" + movie_id;
    }


}
