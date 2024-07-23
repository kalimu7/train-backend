package filerouge.demo.services.ServiceInterfaces;

import filerouge.demo.dtos.PassengerDto;
import filerouge.demo.dtos.TicketDto;

import java.util.List;

public interface TicketServiceImp {

    TicketDto bookTicket(TicketDto ticketDto);

    List<TicketDto> getTickets(Long passenger_id );

}
