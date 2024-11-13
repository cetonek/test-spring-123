package com.example.test.demo.db;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {

  @Query("Select t from Ticket t order by t.id asc limit 1")
  Optional<Ticket> findFirstTicket();

}
