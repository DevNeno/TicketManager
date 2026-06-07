package com.ticket.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.demo.model.dto.TicketRequest;
import com.ticket.demo.model.dto.TicketResponse;
import com.ticket.demo.service.TicketService;

import jakarta.validation.Valid;





@RestController
@RequestMapping(path="/api/ticket")
public class TicketController {
    
    @Autowired
    private TicketService ticketService;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAllTickets(){
        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable Long id) {
        return new ResponseEntity<>(ticketService.getTicket(id), HttpStatus.OK);
    }


    /*
    JSON EXAMPLE:
    {
        ...
    }
    */
    @PostMapping
    public ResponseEntity<TicketResponse> addTicket(@Valid @RequestBody TicketRequest ticket) {
        return new ResponseEntity<>(ticketService.addTicket(ticket), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketResponse> modifyTicket(@PathVariable Long id, @Valid @RequestBody TicketRequest ticket) {
        return new ResponseEntity<>(ticketService.modifyTicket(id, ticket), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
