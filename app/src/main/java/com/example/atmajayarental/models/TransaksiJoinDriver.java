package com.example.atmajayarental.models;

import com.google.gson.annotations.SerializedName;

public class TransaksiJoinDriver {
    private String nama;
    @SerializedName("driver_id")
    private String id_driver;
    @SerializedName("jumlah_transaksi")
    private int jumlahTransaksi;

    public TransaksiJoinDriver(String nama, String id_driver, int jumlahTransaksi) {
        this.nama = nama;
        this.id_driver = id_driver;
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId_driver() {
        return id_driver;
    }

    public void setId_driver(String id_driver) {
        this.id_driver = id_driver;
    }

    public int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(int jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }
}
