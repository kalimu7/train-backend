package filerouge.demo.repositories;

import filerouge.demo.entities.Trajet;
import filerouge.demo.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TrajetRepository extends JpaRepository<Trajet,Long> {

    @Query("SELECT t FROM Trajet t WHERE " +
            "t.departurCity = :departurCityName AND " +
            "t.arrivatCity = :arrivatCityName AND " +
            "t.departureday = :departureday")
    List<Trajet> findTrajets(
            @Param("departurCityName") City departurCityName,
            @Param("arrivatCityName") City arrivatCityName,
            @Param("departureday") LocalDate departureday

    );

}
