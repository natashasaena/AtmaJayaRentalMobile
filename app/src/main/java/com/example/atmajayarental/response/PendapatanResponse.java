package com.example.atmajayarental.response;

import com.example.atmajayarental.models.Pendapatan;
import com.example.atmajayarental.models.TransaksiJoinCustomer;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PendapatanResponse {
    private String message;
    @SerializedName("data")
    private List<Pendapatan> pendapatanList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Pendapatan> getPendapatanList() { return pendapatanList;}

    public void setTransaksiJoinCustomerList(List<Pendapatan> pendapatanList) {
        this.pendapatanList = pendapatanList;
    }
}
