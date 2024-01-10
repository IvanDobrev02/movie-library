package tu.movielibrary.movielibrary.dto;

import java.util.Set;

public record UserDTO(
        String username,
        String firstName,
        String lastName,
        String email,
        String profilePicPath,
        Set<String> roleNames,
        Set<Long> watchListedMovieIds,
        Set<Long> favouriteMovieIds
) {
}
