package com.ticket.demo.service;

import java.util.List;

import com.ticket.demo.model.dto.TicketRequest;
import com.ticket.demo.model.dto.TicketResponse;


public interface TicketService {

    // POST
    TicketResponse addTicket(TicketRequest ticketRequest);

    // GET
    TicketResponse getTicket(Long id);
    List<TicketResponse> getAllTickets();

    // DELETE
    void deleteTicket(Long id);

    // PUT
    TicketResponse modifyTicket(Long id, TicketRequest ticketRequest);
}
