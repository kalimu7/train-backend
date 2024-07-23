package filerouge.demo.services;


import filerouge.demo.Exception.NotfoundException;
import filerouge.demo.dtos.TicketDto;
import filerouge.demo.entities.Passenger;
import filerouge.demo.entities.Ticket;
import filerouge.demo.mappers.TicketMapper;
import filerouge.demo.repositories.PassengersRepository;
import filerouge.demo.repositories.TicketRepository;
import filerouge.demo.services.ServiceInterfaces.TicketServiceImp;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements TicketServiceImp {

    private final PassengersRepository passengersRepository;

    private final TicketRepository ticketRepository;

    public TicketService(PassengersRepository passengersRepository, TicketRepository ticketRepository) {
        this.passengersRepository = passengersRepository;
        this.ticketRepository = ticketRepository;
    }


    @Override
    public TicketDto bookTicket(TicketDto ticketDto) {


        Ticket ticket = TicketMapper.Instance.toEntity(ticketDto);
        ticket.setReservationdate(LocalDate.now());
        ticket = ticketRepository.save(ticket);
        TicketDto ticketDto1 = TicketMapper.Instance.toDto(ticket);

        return ticketDto1;

    }

    @Override
    public List<TicketDto> getTickets(Long passenger_id) {
        Optional<Passenger> passenger = passengersRepository.findById(passenger_id);
        List<TicketDto> ticketDtos = new ArrayList<>();
        if(passenger.isPresent()){

            List<Ticket> tickets = ticketRepository.findAllByPassenger(passenger.get());
            for(Ticket ticket : tickets){
                ticketDtos.add(TicketMapper.Instance.toDto(ticket));
            }

        }else{
            throw new NotfoundException("no passenger with this id ");
        }
        return ticketDtos;
    }




}
