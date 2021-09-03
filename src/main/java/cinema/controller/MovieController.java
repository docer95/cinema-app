package cinema.controller;

import cinema.model.Movie;
import cinema.model.dto.request.MovieRequestDto;
import cinema.model.dto.response.MovieResponseDto;
import cinema.service.MovieService;
import cinema.service.dto.mapping.DtoRequestMapper;
import cinema.service.dto.mapping.DtoResponseMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final DtoRequestMapper<MovieRequestDto, Movie> movieDtoRequestMapper;
    private final DtoResponseMapper<MovieResponseDto, Movie> movieDtoResponseMapper;

    public MovieController(MovieService movieService,
                           DtoRequestMapper<MovieRequestDto, Movie> movieDtoRequestMapper,
                           DtoResponseMapper<MovieResponseDto, Movie> movieDtoResponseMapper) {
        this.movieService = movieService;
        this.movieDtoRequestMapper = movieDtoRequestMapper;
        this.movieDtoResponseMapper = movieDtoResponseMapper;
    }

    @PostMapping
    public MovieResponseDto addMovie(@RequestBody MovieRequestDto dto) {
        Movie movie = movieService.add(movieDtoRequestMapper.fromDto(dto));
        return movieDtoResponseMapper.toDto(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(movieDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
