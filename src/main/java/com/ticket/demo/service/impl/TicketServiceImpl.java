package com.ticket.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ticket.demo.model.dto.TicketRequest;
import com.ticket.demo.model.dto.TicketResponse;
import com.ticket.demo.model.entity.Ticket;
import com.ticket.demo.repository.TicketRepository;
import com.ticket.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {


    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    // POST
    @Override
    public TicketResponse addTicket(TicketRequest ticketRequest){
        Ticket ticket = new Ticket(ticketRequest.title(),  ticketRequest.description(), ticketRequest.priority(), LocalDateTime.now());
        Ticket savedTicket = ticketRepository.save(ticket);
        
        TicketResponse ticketResponse = new TicketResponse(savedTicket.getId(), savedTicket.getTitle(), savedTicket.getDescription(), savedTicket.getPriority(), savedTicket.getCreationDate());
        return ticketResponse;
    }


    // GET ALL
    @Override
    public List<TicketResponse> getAllTickets(){
        List<TicketResponse> response = new ArrayList<>();

        List<Ticket> tickets = ticketRepository.findAll();

        for (Ticket ticket : tickets){
            TicketResponse ticketResponse = new TicketResponse(ticket.getId(), ticket.getTitle() ,ticket.getDescription(), ticket.getPriority(), ticket.getCreationDate());
            response.add(ticketResponse);
        }
        return response;

    }

    // GET BY ID
    @Override
    public TicketResponse getTicket(Long id){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        
        if(!ticketOptional.isPresent()){
            throw new ResourceNotFoundException("Ticket with ID:"+id+" was not found");
        }
        
        Ticket ticket = ticketOptional.get();

        TicketResponse ticketResponse = new TicketResponse(ticket.getId(), ticket.getTitle(), ticket.getDescription(), ticket.getPriority(), ticket.getCreationDate());

        return ticketResponse;
        
    }

    // DELETE
    @Override
    public void deleteTicket(Long id){
        if(ticketRepository.existsById(id)){
            ticketRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("Ticket with ID:"+id+" was not found");
        }
    }

    // PUT
    @Override
    public TicketResponse modifyTicket(Long id, TicketRequest ticketRequest){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);

        if(!ticketOptional.isPresent()){
            throw new ResourceNotFoundException("Ticket with ID: "+id+" was not found");
        }
        Ticket ticket = ticketOptional.get();
        ticket.setTitle(ticketRequest.title());
        ticket.setDescription(ticketRequest.description());
        ticket.setPriority(ticketRequest.priority());

        ticketRepository.save(ticket);
            
        TicketResponse ticketResponse = new TicketResponse(ticket.getId(), ticket.getTitle(), ticket.getDescription(), ticket.getPriority(), ticket.getCreationDate());

        return ticketResponse;
    }


}
