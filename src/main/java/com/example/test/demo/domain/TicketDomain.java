package com.example.test.demo.domain;

import com.example.test.demo.db.Ticket;

import java.time.LocalDateTime;

public class TicketDomain {

  private long number;

  private LocalDateTime created;

  private long order;

  public static TicketDomain from(Ticket ticket, long order) {
    return new TicketDomain()
      .setNumber(ticket.getId())
      .setCreated(ticket.getCreatedAt())
      .setOrder(order);
  }

  public long getNumber() {
    return number;
  }

  public TicketDomain setNumber(long number) {
    this.number = number;
    return this;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public TicketDomain setCreated(LocalDateTime created) {
    this.created = created;
    return this;
  }

  public long getOrder() {
    return order;
  }

  public TicketDomain setOrder(long order) {
    this.order = order;
    return this;
  }
}
