package com.example.atmajayarental.response;

import com.example.atmajayarental.models.TransaksiJoinCustomer;
import com.example.atmajayarental.models.TransaksiJoinDriver;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransaksiJoinDriverResponse {
    private String message;
    @SerializedName("data")
    private List<TransaksiJoinDriver> transaksiJoinDriverList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TransaksiJoinDriver>getTransaksiJoinDriverList() { return transaksiJoinDriverList;}

    public void setTransaksiJoinDriverList(List<TransaksiJoinDriver> transaksiJoinDriverList) {
        this.transaksiJoinDriverList= transaksiJoinDriverList;
    }
}
