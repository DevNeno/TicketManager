package com.ticket.demo.model.entity;

import java.time.LocalDateTime;

import com.ticket.demo.model.enumeration.Priority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;
    private String description;

    private Priority priority;
    private LocalDateTime creationDate;

    public Ticket(){}

    public Ticket(String title, String description, Priority priority, LocalDateTime creationDate){
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.creationDate = creationDate;
    }

    // GETTERS
    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public Priority getPriority(){
        return this.priority;
    }

    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }


    // SETTERS
    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPriority(Priority priority){
        this.priority = priority;
    }

    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }
}