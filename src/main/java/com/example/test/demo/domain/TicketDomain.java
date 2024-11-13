package com.example.test.demo.domain;

import com.example.test.demo.db.Ticket;

import java.time.LocalDateTime;

public class TicketDomain {

  private long id;

  private LocalDateTime created;

  private long order;

  public static TicketDomain from(Ticket ticket, long order) {
    return new TicketDomain()
      .setId(ticket.getId())
      .setCreated(ticket.getCreatedAt())
      .setOrder(order);
  }

  public long getId() {
    return id;
  }

  public TicketDomain setId(long id) {
    this.id = id;
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
