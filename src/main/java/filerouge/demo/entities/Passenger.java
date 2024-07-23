package filerouge.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(mappedBy="passenger")
    private List<Ticket> ticketList ;
    private String password;
    private String email;
    private String name;
    private String cin;
}
