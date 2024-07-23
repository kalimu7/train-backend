package filerouge.demo.repositories;

import filerouge.demo.entities.Passenger;
import filerouge.demo.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findAllByPassenger(Passenger passenger);

}
