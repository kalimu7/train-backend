package filerouge.demo.services.ServiceInterfaces;

import filerouge.demo.dtos.PassengerDto;
import filerouge.demo.entities.Passenger;

public interface PassengersServiceImp {

    PassengerDto AddPassenger(PassengerDto passengerDto);
    PassengerDto login(String email ,String password);

}
