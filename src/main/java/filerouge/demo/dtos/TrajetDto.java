package filerouge.demo.dtos;


import filerouge.demo.entities.Ticket;
import filerouge.demo.enums.City;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TrajetDto {

    private Long id;
    private City departurCity;
    private City arrivatCity;
    private float price;
    private LocalDate departureday;
    private LocalDate arrivatday;
    private LocalTime departureTime;
    private LocalTime arrivatTime;

}
