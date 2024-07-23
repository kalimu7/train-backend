package filerouge.demo.services;


import filerouge.demo.Exception.NotfoundException;
import filerouge.demo.config.SecurityUtils;
import filerouge.demo.dtos.PassengerDto;
import filerouge.demo.entities.Passenger;
import filerouge.demo.mappers.PassengerMapper;
import filerouge.demo.repositories.PassengersRepository;
import filerouge.demo.services.ServiceInterfaces.PassengersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PassengersService implements PassengersServiceImp {

    @Autowired
    private final PassengersRepository passengersRepository;

    @Autowired
    private final SecurityUtils securityUtils;



    @Autowired
    public PassengersService(PassengersRepository passengersRepository, SecurityUtils securityUtils) {

        this.passengersRepository = passengersRepository;


        this.securityUtils = securityUtils;
    }


    @Override
    public PassengerDto AddPassenger(PassengerDto passengerDto) {

        Passenger passenger = PassengerMapper.passengerMapper.toEntity(passengerDto);
        passenger.setPassword(securityUtils.hashPassword(passenger.getPassword()));
        System.out.println("passenger " +  passenger);
        Passenger passenger1 = this.passengersRepository.save(passenger);
        PassengerDto passengerDto1 = PassengerMapper.passengerMapper.toDto(passenger1);
        return passengerDto1;

    }

    @Override
    public PassengerDto login(String email, String password) {

        Passenger passenger = this.passengersRepository.findByEmail(email);
        if (passenger != null) {
            if (securityUtils.verifyPassword(password,passenger.getPassword())) {
                return PassengerMapper.passengerMapper.toDto(passenger);
            }else{
                throw new NotfoundException("Password not correct " + email);
            }
        }else{

            throw new NotfoundException("User not found with email: " + email);
        }

    }
}
