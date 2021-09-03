package cinema.service.dto.mapping.impl.request;

import cinema.model.CinemaHall;
import cinema.model.dto.request.CinemaHallRequestDto;
import cinema.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallRequestMapper implements DtoRequestMapper<CinemaHallRequestDto, CinemaHall> {
    @Override
    public CinemaHall fromDto(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(dto.getCapacity());
        cinemaHall.setDescription(dto.getDescription());
        return cinemaHall;
    }
}
