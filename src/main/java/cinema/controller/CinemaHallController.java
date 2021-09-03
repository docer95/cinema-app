package cinema.controller;

import cinema.model.CinemaHall;
import cinema.model.dto.request.CinemaHallRequestDto;
import cinema.model.dto.response.CinemaHallResponseDto;
import cinema.service.CinemaHallService;
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
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final DtoRequestMapper<CinemaHallRequestDto, CinemaHall> cinemaHallDtoRequestMapper;
    private final DtoResponseMapper<CinemaHallResponseDto, CinemaHall> cinemaHallDtoResponseMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                DtoRequestMapper<CinemaHallRequestDto, CinemaHall>
                                        cinemaHallDtoRequestMapper,
                                DtoResponseMapper<CinemaHallResponseDto, CinemaHall>
                                        cinemaHallDtoResponseMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoRequestMapper = cinemaHallDtoRequestMapper;
        this.cinemaHallDtoResponseMapper = cinemaHallDtoResponseMapper;
    }

    @PostMapping
    public CinemaHallResponseDto addCinemaHall(@RequestBody CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = cinemaHallService.add(cinemaHallDtoRequestMapper.fromDto(dto));
        return cinemaHallDtoResponseMapper.toDto(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
