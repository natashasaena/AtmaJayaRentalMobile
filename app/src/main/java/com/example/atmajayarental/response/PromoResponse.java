package com.example.atmajayarental.response;

import com.example.atmajayarental.models.Promo;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PromoResponse {
    private String message;
    @SerializedName("result")
    ArrayList<Promo> promoArrayList;

    public ArrayList<Promo> getPromoArrayList() {
        return promoArrayList;
    }

    public void setPromoArrayList(ArrayList<Promo> promoArrayList) {
        this.promoArrayList = promoArrayList;
    }
            }

