package filerouge.demo.repositories;

import filerouge.demo.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengersRepository extends JpaRepository<Passenger,Long> {

    Passenger findByEmail(String email);
    Optional<Passenger> findById(Long id);
}
