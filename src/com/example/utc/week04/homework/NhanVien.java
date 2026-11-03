package com.example.utc.week04.homework;

public class NhanVien extends Nguoi {
    private static final int LUONG_CO_BAN = 1_500_000;
    private static final int PHU_CAP_MOI_NAM = 200_000;

    private int snct;
    private double hsl;

    public int getSnct() {
        return snct;
    }

    public double getHsl() {
        return hsl;
    }

    public void nhap(String hoTen, int tuoi, int snct, double hsl) {
        super.nhap(hoTen, tuoi);
        this.snct = snct;
        this.hsl = hsl;
    }

    public double tinhTienLuong() {
        return LUONG_CO_BAN * hsl + (long) PHU_CAP_MOI_NAM * snct;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("  Công tác: %d năm | Hệ số: %s | Lương: %,.2f đồng%n", snct, hsl, tinhTienLuong());
    }
}
