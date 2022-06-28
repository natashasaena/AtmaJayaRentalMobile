package com.example.atmajayarental.response;

import com.example.atmajayarental.models.TransaksiJoinCustomer;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransaksiJoinCustomerResponse {
    private String message;
    @SerializedName("data")
    private List<TransaksiJoinCustomer> transaksiJoinCustomerList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TransaksiJoinCustomer> getTransaksiJoinCustomerList() { return transaksiJoinCustomerList;}

    public void setTransaksiJoinCustomerList(List<TransaksiJoinCustomer> transaksiJoinCustomerList) {
        this.transaksiJoinCustomerList = transaksiJoinCustomerList;
    }
}
