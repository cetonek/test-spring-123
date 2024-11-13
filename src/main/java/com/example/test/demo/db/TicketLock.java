package com.example.test.demo.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_lock")
public class TicketLock {

  @Id
  private Long id;

  public Long getId() {
    return id;
  }

  public TicketLock setId(Long id) {
    this.id = id;
    return this;
  }
}
