package cinema.service.dto.mapping;

public interface DtoRequestMapper<D, C> {
    C fromDto(D dto);
}
