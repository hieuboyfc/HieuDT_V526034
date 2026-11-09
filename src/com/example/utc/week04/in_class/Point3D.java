package com.example.utc.week04.in_class;

public class Point3D extends Point2D {

    private double z;

    public Point3D(double x, double y) {
        super(x, y);
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double distance() {
        return Math.sqrt(super.distance() * super.distance() + this.z * this.z);
    }

    public void translate(double dx, double dy, double dz) {
        super.translate(dx, dy);
        this.z += dz;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                '}';
    }

}
