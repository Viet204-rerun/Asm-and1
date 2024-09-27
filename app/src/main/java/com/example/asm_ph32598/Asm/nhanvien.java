package com.example.asm_ph32598.Asm;

public class nhanvien {
    private String manv;
    private String hoTen;
    private String phongBan;

    public nhanvien(String manv, String hoTen, String phongBan) {
        this.manv = manv;
        this.hoTen = hoTen;
        this.phongBan = phongBan;
    }

    public nhanvien() {
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
}
