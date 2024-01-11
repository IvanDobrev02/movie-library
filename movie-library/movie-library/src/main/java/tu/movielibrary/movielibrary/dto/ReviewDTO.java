package tu.movielibrary.movielibrary.dto;

import java.util.List;

public record ReviewDTO(
        String content,
        Integer movieRating,
        Long dateTimeMilli,
        Integer likes,
        List<String> comments,
        Long userId,
        Long movieId,
        String dateTimeString
) {
}
