package filerouge.demo.controller;


import filerouge.demo.dtos.PassengerDto;
import filerouge.demo.entities.Passenger;
import filerouge.demo.services.PassengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paasenger")
public class PassengerController {

    final PassengersService passengersService;

    @Autowired
    public PassengerController(PassengersService passengersService) {

        this.passengersService = passengersService;

    }


    @PostMapping(value = "/register")
    public ResponseEntity cretePassenger(@RequestBody PassengerDto passengerDto) {
       //return ResponseEntity.ok(passengerDto);
       return  ResponseEntity.ok(passengersService.AddPassenger(passengerDto));

    }



    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody PassengerDto passengerDto) {

        return ResponseEntity.ok(passengersService.login(passengerDto.email,passengerDto.password));

    }





}
