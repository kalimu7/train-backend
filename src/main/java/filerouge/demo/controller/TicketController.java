package filerouge.demo.controller;


import filerouge.demo.dtos.TicketDto;
import filerouge.demo.dtos.TrajetDto;
import filerouge.demo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;


    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/book")
    public ResponseEntity cretePassenger(@RequestBody TicketDto ticketDto) {


        return ResponseEntity.ok(ticketService.bookTicket(ticketDto));

    }

    @GetMapping(value = "/mybooking/{passengerId}")
    public ResponseEntity login(@PathVariable Long passengerId) {

        return ResponseEntity.ok(ticketService.getTickets(passengerId));

    }

}
