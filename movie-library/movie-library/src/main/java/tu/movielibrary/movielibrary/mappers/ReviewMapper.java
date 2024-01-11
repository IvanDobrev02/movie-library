package tu.movielibrary.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import tu.movielibrary.movielibrary.dto.ReviewDTO;
import tu.movielibrary.movielibrary.model.Review;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewMapper {
    @Mapping(target = "content", source = "dto.content")
    @Mapping(target = "movieRating", source = "dto.movieRating")
    @Mapping(target = "dateTimeMilli", source = "dto.dateTimeMilli")
    @Mapping(target = "likes", source = "dto.likes")
    @Mapping(target = "comments", source = "dto.comments")
    @Mapping(target = "userId", source = "dto.userId")
    @Mapping(target = "movieId", source = "dto.movieId")
    @Mapping(target = "dateTimeString", source = "dto.dateTimeString")
    Review convertDtoToEntity(ReviewDTO dto, Long id);
}
