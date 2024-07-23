package filerouge.demo.controller;


import filerouge.demo.dtos.PassengerDto;
import filerouge.demo.dtos.TrajetDto;
import filerouge.demo.services.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trajet")
public class TrajetController {

    private final TrajetService trajetService;

    @Autowired
    public TrajetController(TrajetService trajetService) {
        this.trajetService = trajetService;
    }


    @PostMapping(value = "/add")
    public ResponseEntity cretePassenger(@RequestBody TrajetDto trajetDto) {

        return ResponseEntity.ok(trajetService.AddTrajet(trajetDto));


    }

    @PostMapping("/search")
    public ResponseEntity search(@RequestBody TrajetDto trajetDto) {
        return ResponseEntity.ok(trajetService.SearchTrajet(trajetDto));
    }

}
