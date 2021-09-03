package cinema.service.dto.mapping.impl.response;

import cinema.model.Order;
import cinema.model.Ticket;
import cinema.model.dto.response.OrderResponseDto;
import cinema.service.dto.mapping.DtoResponseMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setTicketIds(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setUser(order.getUser());
        return orderResponseDto;
    }
}
