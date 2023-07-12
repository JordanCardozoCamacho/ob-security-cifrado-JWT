package com.jordan.obsecuritycifradoJWT.dto;

/**
 * Data Transfer Object
 */

public class CountDTO {

    private Long count;
    private String message;

    public CountDTO(){

    }

    public CountDTO(Long count){
        this.count = count;
    }

    public void setCount(Long count){
        this.count = count;
    }

    public Long getCount(){
        return this.count;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
