package cinema.service.dto.mapping.impl.request;

import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.dto.request.MovieSessionRequestDto;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.dto.mapping.DtoRequestMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestMapper implements DtoRequestMapper<MovieSessionRequestDto,
                                                                   MovieSession> {
    public static final String PATTERN = "dd.MM.yyyy HH:mm";
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    public MovieSessionRequestMapper(CinemaHallService cinemaHallService,
                                     MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @Override
    public MovieSession fromDto(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        Movie movie = movieService.get(dto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.get(dto.getCinemaHallId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        movieSession.setMovie(movie);
        movieSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        movieSession.setCinemaHall(cinemaHall);
        return movieSession;
    }
}
