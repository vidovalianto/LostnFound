package com.example.vidovalianto.lostnfound.Model;

import java.util.ArrayList;

/**
 * Created by VidoValianto on 11/28/17.
 */

public class Item {

    private String barang;
    private String hari;
    private String lokasi;
    private String statusBarang;

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getStatus() { return statusBarang; }

    public void setStatusBarang(String status) { statusBarang = status; }

    public String getStatusBarang() {
        return statusBarang;
    }
}
