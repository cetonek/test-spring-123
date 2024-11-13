package com.example.test.demo.service;

import com.example.test.demo.db.Ticket;
import com.example.test.demo.db.TicketLockRepository;
import com.example.test.demo.db.TicketRepository;
import com.example.test.demo.domain.TicketDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TicketService {

  @Autowired
  private TicketRepository ticketRepository;

  @Autowired
  private TicketLockRepository ticketLockRepository;

  @Transactional
  public TicketDomain generateNew() {
    ticketLockRepository.lockTicket();

    long count = ticketRepository.count();

    Ticket created = ticketRepository.save(
      new Ticket()
        .setCreatedAt(LocalDateTime.now())
    );

    return TicketDomain.from(created, count);
  }

  @Transactional(readOnly = true)
  public Optional<TicketDomain> findCurrent() {
    return ticketRepository.findFirstTicket()
      .map(ticket -> TicketDomain.from(ticket, 0));
  }

  @Transactional
  public void deleteCurrent() {
    ticketLockRepository.lockTicket();

    ticketRepository.findFirstTicket()
      .ifPresent(ticket ->
        ticketRepository.deleteById(ticket.getId())
      );
  }
}
