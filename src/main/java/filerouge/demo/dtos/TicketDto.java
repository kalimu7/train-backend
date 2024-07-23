package filerouge.demo.dtos;

import filerouge.demo.entities.Passenger;
import filerouge.demo.entities.Trajet;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TicketDto {

    public Long id;

    public LocalDate reservationdate;

    public Integer numberOfPassengers;

    public Long passenger_id;  // The field name should be consistent with the mappedBy attribute in the Passengers entity

    public Long trajet_id;

}
