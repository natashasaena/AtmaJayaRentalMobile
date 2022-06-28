package com.example.atmajayarental.models;

public class Transaksi {
    private String id_transaksi;
    private String id_pegawai;
    private String id_driver;
    private String id_customer;
    private int id_mobil;
    private String jenis_penyewaan;
    private String tgl_transaksi;
    private String tgl_mulai_sewa;
    private String tgl_selesai;
    private String tgl_pengembalian;
    private Double sub_total;
    private String status_penyewaan;
    private String tgl_pembayaran;
    private String metode_pembayaran;
    private Double total_diskon;
    private Double total_denda;
    private Double total_harga_bayar;
    private String bukti_pembayaran;
    private Double rating_driver;
    private String performa_driver;
    private Double rating_rental;
    private String performa_rating;

    public Transaksi(String id_transaksi, String id_pegawai, String id_driver, String id_customer,
                     int id_mobil, String jenis_penyewaan, String tgl_transaksi, String tgl_mulai_sewa,
                     String tgl_selesai, String tgl_pengembalian, Double sub_total, String status_penyewaan,
                     String tgl_pembayaran, String metode_pembayaran, Double total_diskon,
                     Double total_denda, Double total_harga_bayar, String bukti_pembayaran,
                     Double rating_driver, String performa_driver, Double rating_rental, String performa_rating) {
        this.id_transaksi = id_transaksi;
        this.id_pegawai = id_pegawai;
        this.id_driver = id_driver;
        this.id_customer = id_customer;
        this.id_mobil = id_mobil;
        this.jenis_penyewaan = jenis_penyewaan;
        this.tgl_transaksi = tgl_transaksi;
        this.tgl_mulai_sewa = tgl_mulai_sewa;
        this.tgl_selesai = tgl_selesai;
        this.tgl_pengembalian = tgl_pengembalian;
        this.sub_total = sub_total;
        this.status_penyewaan = status_penyewaan;
        this.tgl_pembayaran = tgl_pembayaran;
        this.metode_pembayaran = metode_pembayaran;
        this.total_diskon = total_diskon;
        this.total_denda = total_denda;
        this.total_harga_bayar = total_harga_bayar;
        this.bukti_pembayaran = bukti_pembayaran;
        this.rating_driver = rating_driver;
        this.performa_driver = performa_driver;
        this.rating_rental = rating_rental;
        this.performa_rating = performa_rating;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(String id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getId_driver() {
        return id_driver;
    }

    public void setId_driver(String id_driver) {
        this.id_driver = id_driver;
    }

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(int id_mobil) {
        this.id_mobil = id_mobil;
    }

    public String getJenis_penyewaan() {
        return jenis_penyewaan;
    }

    public void setJenis_penyewaan(String jenis_penyewaan) {
        this.jenis_penyewaan = jenis_penyewaan;
    }

    public String getTgl_transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_transaksi(String tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public String getTgl_mulai_sewa() {
        return tgl_mulai_sewa;
    }

    public void setTgl_mulai_sewa(String tgl_mulai_sewa) {
        this.tgl_mulai_sewa = tgl_mulai_sewa;
    }

    public String getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(String tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public String getTgl_pengembalian() {
        return tgl_pengembalian;
    }

    public void setTgl_pengembalian(String tgl_pengembalian) {
        this.tgl_pengembalian = tgl_pengembalian;
    }

    public Double getSub_total() {
        return sub_total;
    }

    public void setSub_total(Double sub_total) {
        this.sub_total = sub_total;
    }

    public String getStatus_penyewaan() {
        return status_penyewaan;
    }

    public void setStatus_penyewaan(String status_penyewaan) {
        this.status_penyewaan = status_penyewaan;
    }

    public String getTgl_pembayaran() {
        return tgl_pembayaran;
    }

    public void setTgl_pembayaran(String tgl_pembayaran) {
        this.tgl_pembayaran = tgl_pembayaran;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public Double getTotal_diskon() {
        return total_diskon;
    }

    public void setTotal_diskon(Double total_diskon) {
        this.total_diskon = total_diskon;
    }

    public Double getTotal_denda() {
        return total_denda;
    }

    public void setTotal_denda(Double total_denda) {
        this.total_denda = total_denda;
    }

    public Double getTotal_harga_bayar() {
        return total_harga_bayar;
    }

    public void setTotal_harga_bayar(Double total_harga_bayar) {
        this.total_harga_bayar = total_harga_bayar;
    }

    public String getBukti_pembayaran() {
        return bukti_pembayaran;
    }

    public void setBukti_pembayaran(String bukti_pembayaran) {
        this.bukti_pembayaran = bukti_pembayaran;
    }

    public Double getRating_driver() {
        return rating_driver;
    }

    public void setRating_driver(Double rating_driver) {
        this.rating_driver = rating_driver;
    }

    public String getPerforma_driver() {
        return performa_driver;
    }

    public void setPerforma_driver(String performa_driver) {
        this.performa_driver = performa_driver;
    }

    public Double getRating_rental() {
        return rating_rental;
    }

    public void setRating_rental(Double rating_rental) {
        this.rating_rental = rating_rental;
    }

    public String getPerforma_rating() {
        return performa_rating;
    }

    public void setPerforma_rating(String performa_rating) {
        this.performa_rating = performa_rating;
    }
}
