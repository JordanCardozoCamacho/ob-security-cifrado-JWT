package com.jordan.obsecuritycifradoJWT.security.payload;

public class JwtResponse {
    private String token;

    public JwtResponse(){

    }
    public JwtResponse(String token){
        this.token = token;
    }

    public void setToken(String token){
        this.token = token;
    }
     public String getToken(){
        return this.token;
     }
}
