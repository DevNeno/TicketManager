package com.ticket.demo.model.dto;

import java.time.LocalDateTime;

import com.ticket.demo.model.enumeration.Priority;

public record TicketResponse(Long id, String title, String description, Priority priority, LocalDateTime creationDate){}