package com.example.atmajayarental.models;

import com.google.gson.annotations.SerializedName;

public class Promo {
    private int id_promo;
    private String kode_promo;
    private String jenis_promo;
    private String keterangan;
    private double besar_diskon;
    private String status_promo;

    public Promo(int id_promo, String kode_promo, String jenis_promo, String keterangan, double besar_diskon, String status_promo) {
        this.id_promo = id_promo;
        this.kode_promo = kode_promo;
        this.jenis_promo = jenis_promo;
        this.keterangan = keterangan;
        this.besar_diskon = besar_diskon;
        this.status_promo = status_promo;
    }

    public int getId_promo() {
        return id_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public String getKode_promo() {
        return kode_promo;
    }

    public void setKode_promo(String kode_promo) {
        this.kode_promo = kode_promo;
    }

    public String getJenis_promo() {
        return jenis_promo;
    }

    public void setJenis_promo(String jenis_promo) {
        this.jenis_promo = jenis_promo;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public double getBesar_diskon() {
        return besar_diskon;
    }

    public void setBesar_diskon(double besar_diskon) {
        this.besar_diskon = besar_diskon;
    }

    public String getStatus_promo() {
        return status_promo;
    }

    public void setStatus_promo(String status_promo) {
        this.status_promo = status_promo;
    }
}
