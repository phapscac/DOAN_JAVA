/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class User {
    String maNV;
    String hoEN;
    String quyen;
    String tinh;
    Date ngaySinh;
    String soDT;

    public User(String maNV, String hoEN, String quyen, String tinh, Date ngaySinh, String soDT) {
        this.maNV = maNV;
        this.hoEN = hoEN;
        this.quyen = quyen;
        this.tinh = tinh;
        this.ngaySinh = ngaySinh;
        this.soDT = soDT;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public User(String maNV, String hoEN, String quyen, String tinh, Date ngaySinh) {
        this.maNV = maNV;
        this.hoEN = hoEN;
        this.quyen = quyen;
        this.tinh = tinh;
        this.ngaySinh = ngaySinh;
    }
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoEN() {
        return hoEN;
    }

    public void setHoEN(String hoEN) {
        this.hoEN = hoEN;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public User(String maNV, String hoEN, String quyen) {
        this.maNV = maNV;
        this.hoEN = hoEN;
        this.quyen = quyen;
    }
    
}
