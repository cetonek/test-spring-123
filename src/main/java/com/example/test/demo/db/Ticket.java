package com.example.test.demo.db;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Long version;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  public Long getVersion() {
    return version;
  }

  public Ticket setVersion(Long version) {
    this.version = version;
    return this;
  }

  public java.time.LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public Ticket setCreatedAt(java.time.LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

}
