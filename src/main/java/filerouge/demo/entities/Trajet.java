package filerouge.demo.entities;

import filerouge.demo.enums.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private City departurCity;

    @Enumerated(EnumType.STRING)
    private City arrivatCity;

    private float price;
    private LocalDate departureday;
    private LocalDate arrivatday;
    private LocalTime departureTime;
    private LocalTime arrivatTime;

    @OneToMany(mappedBy = "trajet")
    private List<Ticket> tickets;




}
