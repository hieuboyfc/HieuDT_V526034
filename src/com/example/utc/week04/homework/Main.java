package com.example.utc.week04.homework;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n;
            while (true) {
                System.out.print("Nhập số lượng nhân viên: ");
                try {
                    n = Integer.parseInt(scanner.nextLine().trim());
                    if (n >= 1) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    // Báo lỗi bên dưới rồi nhập lại trường này.
                }
                System.out.println("---> Vui lòng nhập số nguyên từ 1 trở lên.");
            }

            List<NhanVien> danhSach = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Nhân viên thứ " + (i + 1));
                System.out.print("Họ tên: ");
                String hoTen = scanner.nextLine().trim();

                int tuoi;
                while (true) {
                    System.out.print("Tuổi: ");
                    try {
                        tuoi = Integer.parseInt(scanner.nextLine().trim());
                        if (tuoi >= 0) {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        // Báo lỗi bên dưới rồi nhập lại trường này.
                    }
                    System.out.println("---> Vui lòng nhập số nguyên từ 0 trở lên.");
                }

                int snct;
                while (true) {
                    System.out.print("Số năm công tác: ");
                    try {
                        snct = Integer.parseInt(scanner.nextLine().trim());
                        if (snct >= 0) {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        // Báo lỗi bên dưới rồi nhập lại trường này.
                    }
                    System.out.println("Vui lòng nhập số nguyên từ 0 trở lên.");
                }

                double hsl;
                while (true) {
                    System.out.print("Hệ số lương: ");
                    try {
                        hsl = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                        if (Double.isFinite(hsl) && hsl >= 0) {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        // Báo lỗi bên dưới rồi nhập lại trường này.
                    }
                    System.out.println("Vui lòng nhập hệ số lương là số hữu hạn không âm.");
                }

                NhanVien nhanVien = new NhanVien();
                nhanVien.nhap(hoTen, tuoi, snct, hsl);
                danhSach.add(nhanVien);
            }

            int soNamNhieuNhat = danhSach.stream()
                    .mapToInt(NhanVien::getSnct)
                    .max()
                    .getAsInt();

            System.out.println("\nNhân viên có số năm công tác nhiều nhất:");
            for (NhanVien nhanVien : danhSach) {
                if (nhanVien.getSnct() == soNamNhieuNhat) {
                    nhanVien.xuat();
                }
            }

            danhSach.sort(Comparator.comparingDouble(NhanVien::tinhTienLuong).reversed());
            System.out.println("\nDanh sách nhân viên theo lương từ cao đến thấp:");
            for (NhanVien nhanVien : danhSach) {
                nhanVien.xuat();
            }
        } catch (NoSuchElementException e) {
            System.out.println("\nĐã hết dữ liệu nhập.");
        }
    }
}
