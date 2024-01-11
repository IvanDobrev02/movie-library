package tu.movielibrary.movielibrary.controllers.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tu.movielibrary.movielibrary.dto.ActorDTO;
import tu.movielibrary.movielibrary.dto.MovieDTO;
import tu.movielibrary.movielibrary.dto.ReviewDTO;
import tu.movielibrary.movielibrary.mappers.ActorMapper;
import tu.movielibrary.movielibrary.mappers.MovieMapper;
import tu.movielibrary.movielibrary.mappers.ReviewMapper;
import tu.movielibrary.movielibrary.model.Actor;
import tu.movielibrary.movielibrary.model.Movie;
import tu.movielibrary.movielibrary.model.Review;
import tu.movielibrary.movielibrary.service.ActorService;
import tu.movielibrary.movielibrary.service.MovieService;
import tu.movielibrary.movielibrary.service.implementation.ActorServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import tu.movielibrary.movielibrary.service.implementation.MovieServiceImplementation;
import tu.movielibrary.movielibrary.service.implementation.ReviewServiceImplementation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController {

    @Autowired
    private ReviewServiceImplementation reviewService;
    private ReviewMapper reviewMapper;

    @GetMapping ("/api/get/review/{id}")
    public ResponseEntity<?> getSingleReview(@PathVariable Long id) {
        Review review = reviewService.getSingleReview(id);
        return ResponseEntity.ok(review);
    }

//  TO DO!!!
//    @PostMapping("/api/save/review")
//    public ResponseEntity<?> savereview(@RequestBody ReviewDTO dto) {
//
//        Optional<Review> dbObject = reviewService.findByUserId(dto.userId());
//        Long id;
//        if(dbObject.isPresent()) {
//            id = dbObject.get().getId();
//            log.info("Updating review with id {}", id);
//        } else {
//            id = null;
//            log.info("Inserting new review ");
//        }
//        Review review= reviewMapper.convertDtoToEntity(dto, id);
//
//        reviewService.saveReview(review);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @DeleteMapping("/api/delete/review/{id}")
    public ResponseEntity<?> deletereview(@PathVariable Long id) throws Exception {

        Review review = reviewService.getSingleReview(id);
        reviewService.deleteReview(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
