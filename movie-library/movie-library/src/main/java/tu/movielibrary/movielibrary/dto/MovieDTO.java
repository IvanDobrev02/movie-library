package tu.movielibrary.movielibrary.dto;

import java.text.DecimalFormat;
import java.util.Date;

public record MovieDTO (
        String name,
        Date release_date,
        DecimalFormat rating,
        String genre,
        String poster,
        String description

){
}