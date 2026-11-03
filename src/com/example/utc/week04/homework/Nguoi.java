package com.example.utc.week04.homework;

public class Nguoi {
    private String hoTen;
    private int tuoi;

    public String getHoTen() {
        return hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void nhap(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public void xuat() {
        System.out.printf("- Nhân viên: %s, %d tuổi%n", hoTen, tuoi);
    }
}
