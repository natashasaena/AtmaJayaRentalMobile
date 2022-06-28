package com.example.atmajayarental.models;

import com.google.gson.annotations.SerializedName;

public class PerformaDriver {
    @SerializedName("driver_id")
    private String id_driver;
    private String nama;
    @SerializedName("jumlah_transaksi")
    private int jumlahTransaksi;
    @SerializedName("rerata_rating")
    private double rerataDriverRating;

    public PerformaDriver(String id_driver, String nama, int jumlahTransaksi, double rerataDriverRating) {
        this.id_driver = id_driver;
        this.nama = nama;
        this.jumlahTransaksi = jumlahTransaksi;
        this.rerataDriverRating = rerataDriverRating;
    }

    public String getId_driver() {
        return id_driver;
    }

    public void setId_driver(String id_driver) {
        this.id_driver = id_driver;
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

    public double getRerataDriverRating() {
        return rerataDriverRating;
    }

    public void setRerataDriverRating(double rerataDriverRating) {
        this.rerataDriverRating = rerataDriverRating;
    }
}
