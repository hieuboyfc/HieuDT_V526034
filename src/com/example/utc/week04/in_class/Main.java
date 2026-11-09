package com.example.utc.week04.in_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void handlePoint2D() {
        Scanner sc = new Scanner(System.in);
        List<Point2D> points2D = new ArrayList<>();

        System.out.println("Nhập số lượng điểm 2D: ");
        int countPoint = sc.nextInt();

        for (int i = 0; i < countPoint; i++) {
            System.out.println("-------------------------------");
            System.out.println("Nhập tọa độ điểm 2D thứ " + (i + 1) + " (x, y): ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            Point2D point2D = new Point2D(x, y);
            points2D.add(point2D);
            System.out.println(point2D);
            System.out.println("Khoảng cách từ gốc tọa độ đến điểm thứ " + (i + 1) + " là: " + point2D.distance());
        }

        double sumDistance = 0;
        for (Point2D p : points2D) {
            sumDistance += p.distance();
        }
        System.out.println("Tổng khoảng cách từ gốc tọa độ đến tất cả các điểm 2D là: " + sumDistance);

        // Tịnh tiến tất cả các điểm 2D
        System.out.println("Nhập độ lệch tịnh tiến (dx, dy): ");
        double dx = sc.nextDouble();
        double dy = sc.nextDouble();

        for (Point2D p : points2D) {
            p.translate(dx, dy);
            System.out.println("Sau khi tịnh tiến: " + p);
        }

    }

    public static void handlePoint3D() {
        Scanner sc = new Scanner(System.in);
        List<Point3D> points3D = new ArrayList<>();

        System.out.println("Nhập số lượng điểm 3D: ");
        int countPoint = sc.nextInt();

        for (int i = 0; i < countPoint; i++) {
            System.out.println("-------------------------------");
            System.out.println("Nhập tọa độ điểm 3D thứ " + (i + 1) + " (x, y, z): ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double z = sc.nextDouble();
            Point3D point3D = new Point3D(x, y, z);
            points3D.add(point3D);
            System.out.println(point3D);
            System.out.println("Khoảng cách từ gốc tọa độ đến điểm thứ " + (i + 1) + " là: " + point3D.distance());
        }

        double sumDistance = 0;
        for (Point3D p : points3D) {
            sumDistance += p.distance();
        }
        System.out.println("Tổng khoảng cách từ gốc tọa độ đến tất cả các điểm 3D là: " + sumDistance);

        // Tịnh tiến tất cả các điểm 3D
        System.out.println("Nhập độ lệch tịnh tiến (dx, dy, dz): ");
        double dx = sc.nextDouble();
        double dy = sc.nextDouble();
        double dz = sc.nextDouble();

        for (Point3D p : points3D) {
            p.translate(dx, dy, dz);
            System.out.println("Sau khi tịnh tiến: " + p);
        }
    }

    public static void handleUnifiedPoints() {
        Scanner sc = new Scanner(System.in);
        List<Point2D> points = new ArrayList<>();

        // Nhập số lượng điểm từ người dùng
        System.out.println("Nhập số lượng điểm: ");
        int countPoint = sc.nextInt();

        // Nhập tọa độ các điểm từ người dùng
        for (int i = 0; i < countPoint; i++) {
            System.out.println("-------------------------------");
            System.out.println("Nhập tọa độ điểm (x, y, z nếu là 3D, nhập -1 nếu không): ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double z = sc.nextDouble();

            if (z == -1) {
                points.add(new Point2D(x, y));
            } else {
                points.add(new Point3D(x, y, z));
            }
        }

        // Tính tổng khoảng cách từ gốc tọa độ đến tất cả các điểm 2D và 3D
        double totalDistance2D = 0;
        double totalDistance3D = 0;

        for (Point2D p : points) {
            if (p instanceof Point3D) {
                totalDistance3D += p.distance();
            } else {
                totalDistance2D += p.distance();
            }
        }

        System.out.println("Tổng khoảng cách các điểm 2D: " + totalDistance2D);
        System.out.println("Tổng khoảng cách các điểm 3D: " + totalDistance3D);

        // Tạo các điểm đối xứng và thêm vào danh sách
        List<Point2D> symmetricPoints = new ArrayList<>();
        for (Point2D p : points) {
            if (p instanceof Point3D) {
                Point3D p3 = (Point3D) p;
                symmetricPoints.add(new Point3D(-p3.getX(), -p3.getY(), -p3.getZ()));
            } else {
                symmetricPoints.add(new Point2D(-p.getX(), -p.getY()));
            }
        }
        points.addAll(symmetricPoints);

        // Hiển thị danh sách các điểm sau khi thêm các điểm đối xứng
        System.out.println("Danh sách các điểm sau khi thêm điểm đối xứng:");
        for (Point2D p : points) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Xử lý điểm 2D");
            System.out.println("2. Xử lý điểm 3D");
            System.out.println("3. Xử lý điểm 2D và 3D (chung)");
            System.out.println("4. Thoát");
            System.out.println("---> Nhập lựa chọn của bạn (1-4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> handlePoint2D();
                case 2 -> handlePoint3D();
                case 3 -> handleUnifiedPoints();
                case 4 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}