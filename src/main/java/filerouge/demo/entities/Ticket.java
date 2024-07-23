package filerouge.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate reservationdate;

    private Integer numberOfPassengers;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;  // The field name should be consistent with the mappedBy attribute in the Passengers entity

    @ManyToOne
    @JoinColumn(name="trajetid")
    private Trajet trajet;
}
