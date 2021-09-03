package cinema.service.dto.mapping.impl.response;

import cinema.model.ShoppingCart;
import cinema.model.Ticket;
import cinema.model.dto.response.ShoppingCartResponseDto;
import cinema.service.dto.mapping.DtoResponseMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements DtoResponseMapper<ShoppingCartResponseDto,
        ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        shoppingCartResponseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        shoppingCartResponseDto.setUser(shoppingCart.getUser());
        return shoppingCartResponseDto;
    }
}
