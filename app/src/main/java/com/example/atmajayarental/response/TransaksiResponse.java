package com.example.atmajayarental.response;

import com.example.atmajayarental.models.Transaksi;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransaksiResponse {
    private String message;
    @SerializedName("data")
    private List<Transaksi> transaksiList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Transaksi> getTransaksiList() {
        return transaksiList;
    }

    public void setTransaksiList(List<Transaksi> transaksiList) {
        this.transaksiList = transaksiList;
    }
}
