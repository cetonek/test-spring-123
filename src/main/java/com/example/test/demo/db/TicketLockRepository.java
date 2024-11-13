package com.example.test.demo.db;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TicketLockRepository extends JpaRepository<Ticket, Long> {

  @Query("Select l from TicketLock l where l.id = 1")
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  TicketLock lockTicket();

}
