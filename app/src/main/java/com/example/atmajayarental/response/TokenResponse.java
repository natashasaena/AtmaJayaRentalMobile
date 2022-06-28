package com.example.atmajayarental.response;

import com.example.atmajayarental.models.PerformaDriver;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TokenResponse {

    @SerializedName("access_token")
    private  String access_token;

    @SerializedName("token_type")
    private  String token_type;

    @SerializedName("email")
    private  String email;

    public TokenResponse(){

    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getEmail() {
        return email;
    }
}
