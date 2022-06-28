package com.example.atmajayarental.models;

import com.google.gson.annotations.SerializedName;

public class Pendapatan {
    private String nama;
    private String nama_mobil;
    private String jenis_penyewaan;
    @SerializedName("jumlah_transaksi")
    private int jumlahTransaksi;
    @SerializedName("Pendapatan")
    private int jumlaahPendapatan;

    public Pendapatan(String nama, String nama_mobil, String jenis_penyewaan, int jumlahTransaksi, int jumlaahPendapatan) {
        this.nama = nama;
        this.nama_mobil = nama_mobil;
        this.jenis_penyewaan = jenis_penyewaan;
        this.jumlahTransaksi = jumlahTransaksi;
        this.jumlaahPendapatan = jumlaahPendapatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public String getJenis_penyewaan() {
        return jenis_penyewaan;
    }

    public void setJenis_penyewaan(String jenis_penyewaan) {
        this.jenis_penyewaan = jenis_penyewaan;
    }

    public int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(int jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public int getJumlaahPendapatan() {
        return jumlaahPendapatan;
    }

    public void setJumlaahPendapatan(int jumlaahPendapatan) {
        this.jumlaahPendapatan = jumlaahPendapatan;
    }
}
