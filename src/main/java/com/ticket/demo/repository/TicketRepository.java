package com.ticket.demo.repository;


import org.springframework.data.repository.ListCrudRepository;

import com.ticket.demo.model.entity.Ticket;

public interface TicketRepository extends ListCrudRepository<Ticket, Long>{}