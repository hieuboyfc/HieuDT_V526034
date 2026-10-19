package com.example.utc;

import java.util.Scanner;

public class Learn02 {

    static void ex1(Scanner sc) {
        System.out.println("Nhap so phan tu cua mang: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Nhap khong hop le. Quay lai menu.");
            return;
        }

        int total = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1) + " cua mang: ");
            try {
                a[i] = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Nhap khong hop le. Phan tu thu " + (i + 1) + " duoc mac dinh la 0.");
                a[i] = 0;
            }
            System.out.println("Mang a[" + i + "] = " + a[i]);
            total += a[i];
        }

        System.out.println("Tong cac phan tu trong mang la: " + total);

    }

    static void ex2(Scanner sc) {
        System.out.println("Nhap so phan tu cua mang a: ");
        int m1;
        try {
            m1 = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Nhap khong hop le. Quay lai menu.");
            return;
        }
        int[] a = new int[m1];

        for (int i = 0; i < m1; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1) + " cua mang a: ");
            try {
                a[i] = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Nhap khong hop le. Phan tu thu " + (i + 1) + " duoc mac dinh la 0.");
                a[i] = 0;
            }
            System.out.println("Mang a[" + i + "] = " + a[i]);
        }

        System.out.println("--------------------------------------------");

        System.out.println("Nhap so phan tu cua mang b: ");
        int m2;
        try {
            m2 = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Nhap khong hop le. Quay lai menu.");
            return;
        }
        int[] b = new int[m2];

        for (int i = 0; i < m2; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1) + " cua mang b: ");
            try {
                b[i] = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Nhap khong hop le. Phan tu thu " + (i + 1) + " duoc mac dinh la 0.");
                b[i] = 0;
            }
            System.out.println("Mang b[" + i + "] = " + b[i]);
        }

        int max = Math.max(m1, m2);
        int[] res = new int[max];

        for (int i = 0; i < max; i++) {
            int valueA = (i < m1) ? a[i] : 0;
            int valueB = (i < m2) ? b[i] : 0;
            res[i] = valueA + valueB;
            System.out.println("res[" + i + "] = " + res[i]);
        }
        System.out.println();

        if (res.length > 0) {
            System.out.print("Mang res: ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int re : res) {
                stringBuilder.append(re).append(" ");
            }
            System.out.println(stringBuilder.toString().trim());
        } else {
            System.out.println("Mang res rong.");
        }
    }

    static void ex3(Scanner sc) {
        System.out.println("Nhap cac phan tu cua mang: ");
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println("Số phần tử: 0; Tổng: 0");
            return;
        }

        String[] parts = line.split("\\s+");
        long sum = 0;
        int count = 0;
        for (String p : parts) {
            try {
                sum += Integer.parseInt(p);
                count++;
            } catch (NumberFormatException e) {
                // bỏ qua token không hợp lệ
            }
        }

        System.out.println("Số phần tử: " + count + "; Tổng: " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------");
            System.out.println("--- VUI LONG CHON BAI TAP MUON THUC HIEN ---");
            System.out.println("0. Thoat");
            System.out.println("1. Bai tap 1: Tinh tong cac phan tu");
            System.out.println("2. Bai tap 2: Cong hai mang");
            System.out.println("3. Bai tap 3: Tinh tong cac phan tu");
            System.out.println("--------------------------------------------");
            System.out.print("---> Lua chon: ");

            String line = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("===> Lua chon khong hop le. Thu lai.\n");
                continue;
            }

            if (choice == 0) break;
            switch (choice) {
                case 1:
                    ex1(sc);
                    break;
                case 2:
                    ex2(sc);
                    break;
                case 3:
                    ex3(sc);
                    break;
                default:
                    System.out.println("===> Lua chon khong hop le.\n");
            }
        }
        sc.close();
        System.out.println("Ket thuc chuong trinh.");
    }

}
