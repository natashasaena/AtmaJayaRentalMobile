package com.example.atmajayarental.api;

import com.example.atmajayarental.response.PendapatanResponse;
import com.example.atmajayarental.response.PerformaDriverResponse;
import com.example.atmajayarental.response.PromoResponse;
import com.example.atmajayarental.response.TransaksiJoinCustomerResponse;
import com.example.atmajayarental.response.TransaksiJoinDriverResponse;
import com.example.atmajayarental.response.TransaksiJoinMobilResponse;
import com.example.atmajayarental.response.TransaksiResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @Headers({"Accept: application/json"})
    @GET("transaksi")
    Call<TransaksiResponse> index();

    @Headers({"Accept: application/json"})
    @GET("promo")
    Call<PromoResponse> getAllPromo();

    @Headers({"Accept: application/json"})
    @GET("transaksi/laporan/mobil/{bulan}/{tahun}")
    Call<TransaksiJoinMobilResponse> laporanMobil(@Path("bulan") int bulan, @Path("tahun") int tahun);

    @Headers({"Accept: application/json"})
    @GET("transaksi/laporan/customer/{bulan}/{tahun}")
    Call<TransaksiJoinCustomerResponse> laporanCustomer(@Path("bulan") int bulan, @Path("tahun") int tahun);

    @Headers({"Accept: application/json"})
    @GET("transaksi/laporan/driver/{bulan}/{tahun}")
    Call<TransaksiJoinDriverResponse> laporanDriver(@Path("bulan") int bulan, @Path("tahun") int tahun);

    @Headers({"Accept: application/json"})
    @GET("transaksi/laporan/pendapatan/{bulan}/{tahun}")
    Call<PendapatanResponse> laporanPendapatan(@Path("bulan") int bulan, @Path("tahun") int tahun);

    @Headers({"Accept: application/json"})
    @GET("transaksi/laporan/performa/{bulan}/{tahun}")
    Call<PerformaDriverResponse> laporanPerforma(@Path("bulan") int bulan, @Path("tahun") int tahun);

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("login/customer")
    Call<ResponseBody> login(@Field("email") String name, @Field("password") String password);

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("login/driver")
    Call<ResponseBody> loginDriver(@Field("email") String name, @Field("password") String password);

    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("login/pegawai")
    Call<ResponseBody> loginManager(@Field("email") String name, @Field("password") String password);
}
