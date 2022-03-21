package com.example.btlandroidnhom6.model;

public class Cuahang {
    private String diachi,loaihang,quanly;
    private  int doanhthu;
    private int imageurl;

    public Cuahang(String diachi, String loaihang, String quanly, int doanhthu, int imageurl) {
        this.diachi = diachi;
        this.loaihang = loaihang;
        this.doanhthu = doanhthu;
        this.quanly = quanly;
        this.imageurl = imageurl;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getLoaihang() {
        return loaihang;
    }

    public void setLoaihang(String loaihang) {
        this.loaihang = loaihang;
    }

    public String getQuanly() {
        return quanly;
    }

    public void setQuanly(String quanly) {
        this.quanly = quanly;
    }

    public int getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(int doanhthu) {
        this.doanhthu = doanhthu;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }
}