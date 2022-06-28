package com.example.atmajayarental.response;

import com.example.atmajayarental.models.Pendapatan;
import com.example.atmajayarental.models.PerformaDriver;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PerformaDriverResponse {
    private String message;
    @SerializedName("data")
    private List<PerformaDriver> performaDriverList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PerformaDriver> getPerformaDriverList() { return performaDriverList;}

    public void setPerformaDriverList(List<PerformaDriver> performaDriverList) {
        this.performaDriverList = performaDriverList;
    }
}
