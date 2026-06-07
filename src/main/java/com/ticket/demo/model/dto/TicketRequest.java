package com.ticket.demo.model.dto;

import com.ticket.demo.model.enumeration.Priority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TicketRequest(
    @NotBlank String title,
    @NotBlank String description,
    @NotNull Priority priority
) {}

