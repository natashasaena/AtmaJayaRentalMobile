package com.example.atmajayarental.response;

import com.example.atmajayarental.models.Transaksi;
import com.example.atmajayarental.models.TransaksiJoinMobil;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransaksiJoinMobilResponse {
    private String message;
    @SerializedName("data")
    private List<TransaksiJoinMobil> transaksiJoinMobilList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TransaksiJoinMobil> getTransaksiJoinMobilList() {
        return transaksiJoinMobilList;
    }

    public void setTransaksiJoinMobilList(List<TransaksiJoinMobil> transaksiJoinMobilList) {
        this.transaksiJoinMobilList = transaksiJoinMobilList;
    }
}
