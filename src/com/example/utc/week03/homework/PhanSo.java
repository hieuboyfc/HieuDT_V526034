package com.example.utc.week03.homework;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        setMauSo(mauSo);
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số phải khác 0.");
        }
        this.mauSo = mauSo;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }

    public PhanSo cong(PhanSo phanSo) {
        return congTru(phanSo, 1);
    }

    public PhanSo tru(PhanSo phanSo) {
        return congTru(phanSo, -1);
    }

    private PhanSo congTru(PhanSo phanSo, int dau) {
        // Quy đồng theo mẫu số chung nhỏ nhất.
        long ucln = uocChungLonNhat(mauSo, phanSo.mauSo);
        long heSoTrai = phanSo.mauSo / ucln;
        long heSoPhai = mauSo / ucln;
        return taoPhanSoRutGon(tuSo * heSoTrai + dau * heSoPhai * phanSo.tuSo,
                mauSo * heSoTrai);
    }

    public PhanSo nhan(PhanSo phanSo) {
        return taoPhanSoRutGon((long) tuSo * phanSo.tuSo, (long) mauSo * phanSo.mauSo);
    }

    public PhanSo chia(PhanSo phanSo) {
        if (phanSo.tuSo == 0) {
            throw new ArithmeticException("Không thể chia cho phân số bằng 0.");
        }
        return taoPhanSoRutGon((long) tuSo * phanSo.mauSo, (long) mauSo * phanSo.tuSo);
    }

    // Trả về -1 nếu nhỏ hơn, 0 nếu bằng nhau, 1 nếu lớn hơn.
    public int soSanh(PhanSo phanSo) {
        long trai = (long) tuSo * phanSo.mauSo;
        long phai = (long) phanSo.tuSo * mauSo;
        int ketQua = Long.compare(trai, phai);
        return (mauSo < 0) != (phanSo.mauSo < 0) ? -ketQua : ketQua;
    }

    public PhanSo rutGon() {
        return taoPhanSoRutGon(tuSo, mauSo);
    }

    public boolean laSoNguyen() {
        return tuSo % mauSo == 0;
    }

    private static PhanSo taoPhanSoRutGon(long tuSo, long mauSo) {
        long ucln = uocChungLonNhat(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
        // Dùng mẫu âm nếu đổi dấu giúp cả hai giá trị vừa kiểu int.
        if ((tuSo == (long) Integer.MAX_VALUE + 1 || mauSo == (long) Integer.MAX_VALUE + 1)
                && tuSo != Integer.MIN_VALUE) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
        return new PhanSo(Math.toIntExact(tuSo), Math.toIntExact(mauSo));
    }

    private static long uocChungLonNhat(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long du = a % b;
            a = b;
            b = du;
        }
        return a;
    }
}
