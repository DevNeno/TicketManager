package com.ticket.demo.model.payload;

public class ApiResponse{

    private final String message;

    public ApiResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
