package com.example.utc.week03;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n;
            do {
                n = nhapSoNguyen(sc, "Nhập số lượng phân số: ");
                if (n <= 0) {
                    System.out.println("Số lượng phải lớn hơn 0.");
                }
            } while (n <= 0);

            List<PhanSo> danhSach = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                System.out.println("--- Phân số thứ " + (i + 1) + ":");
                int tuSo = nhapSoNguyen(sc, "  + Tử số: ");
                int mauSo;
                do {
                    mauSo = nhapSoNguyen(sc, "  + Mẫu số: ");
                    if (mauSo == 0) {
                        System.out.println("Mẫu số phải khác 0.");
                    }
                } while (mauSo == 0);
                danhSach.add(new PhanSo(tuSo, mauSo));
            }

            if (danhSach.size() >= 2) {
                hienThiPhepTinh(danhSach.get(0), danhSach.get(1));
            }
            thongKe(danhSach);
        } catch (NoSuchElementException e) {
            System.out.println("\nĐã hết dữ liệu nhập.");
        }
    }

    private static void hienThiPhepTinh(PhanSo a, PhanSo b) {
        System.out.println("\nHai phân số đầu tiên sau khi rút gọn: " + a.rutGon() + " và " + b.rutGon());
        inKetQua("Tổng", () -> a.cong(b));
        inKetQua("Hiệu", () -> a.tru(b));
        inKetQua("Tích", () -> a.nhan(b));
        if (b.getTuSo() == 0) {
            System.out.println("Thương: không thể chia cho phân số bằng 0.");
        } else {
            inKetQua("Thương", () -> a.chia(b));
        }

        int soSanh = a.soSanh(b);
        String dau = soSanh < 0 ? "<" : soSanh > 0 ? ">" : "=";
        System.out.println("So sánh: " + a + " " + dau + " " + b);
    }

    private static void thongKe(List<PhanSo> danhSach) {
        PhanSo lonNhat = danhSach.get(0);
        int soPhanSoKhongNguyen = 0;

        for (PhanSo phanSo : danhSach) {
            if (phanSo.soSanh(lonNhat) > 0) {
                lonNhat = phanSo;
            }
            if (!phanSo.laSoNguyen()) {
                soPhanSoKhongNguyen++;
            }
        }

        System.out.println("\nPhân số lớn nhất: " + lonNhat.rutGon());
        inKetQua("Tổng các phân số", () -> {
            PhanSo tong = new PhanSo(0, 1);
            for (PhanSo phanSo : danhSach) {
                tong = tong.cong(phanSo);
            }
            return tong;
        });
        System.out.println("Số phân số không phải số nguyên: " + soPhanSoKhongNguyen);
    }

    private static void inKetQua(String ten, Supplier<PhanSo> phepTinh) {
        try {
            System.out.println(ten + ": " + phepTinh.get());
        } catch (ArithmeticException e) {
            System.out.println(ten + ": vượt phạm vi số nguyên kiểu int.");
        }
    }

    private static int nhapSoNguyen(Scanner sc, String loiNhac) {
        while (true) {
            System.out.print(loiNhac);
            String dong = sc.nextLine().trim();
            try {
                return Integer.parseInt(dong);
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }
    }
}
