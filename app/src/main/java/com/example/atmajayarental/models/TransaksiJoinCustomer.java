package com.example.atmajayarental.models;

import com.google.gson.annotations.SerializedName;

public class TransaksiJoinCustomer {

    private String nama;
    @SerializedName("jumlah_transaksi")
    private int jumlahTransaksi;

    public TransaksiJoinCustomer(String nama, int jumlahTransaksi) {
        this.nama = nama;
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(int jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }
}