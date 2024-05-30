package Model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ma;
    private String ho;
    private String ten;
    private String nam;
    private String que;
    private String gpa;

    public SinhVien(String ma, String ho, String ten, String nam, String que, String gpa) {
        this.ma = ma;
        this.ho = ho;
        this.ten = ten;
        this.nam = nam;
        this.que = que;
        this.gpa = gpa;
    }

    // Các phương thức getter và setter

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ma='" + ma + '\'' +
                ", ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", nam='" + nam + '\'' +
                ", que='" + que + '\'' +
                ", gpa='" + gpa + '\'' +
                '}';
    }
}
