package com.example.test.demo.web;


import com.example.test.demo.domain.TicketDomain;
import com.example.test.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {


  @Autowired
  private TicketService ticketService;

  @PostMapping("/tickets")
  public TicketDomain generateNew() {
    return ticketService.generateNew();
  }

  @GetMapping("/tickets/current")
  public ResponseEntity<TicketDomain> getCurrent() {
    return ticketService.findCurrent()
      .map(ResponseEntity::ok)
      .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
  }

  @DeleteMapping("/tickets/current")
  public void deleteCurrent() {
    ticketService.deleteCurrent();
  }


}
