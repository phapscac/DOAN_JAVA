/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DANGNHAPCONTROLLER {
    public User  dangnhap(String usename , String password)
    {
        try {
            ConnectProvide con = new ConnectProvide();
            con.open();
            String sql = "select MaNV,Hoten,quyen,Tinh,NgSinh,sdt from NhanVien where MaNV =?and Matkhau=?";
            PreparedStatement pre = con.con.prepareStatement(sql);
            pre.setString(1, usename);
            pre.setString(2, password);
            ResultSet rs =  pre.executeQuery();
            while(rs.next())
            {
                User user  = new User(rs.getString("MaNV"),rs.getString("Hoten"), rs.getString("quyen"),rs.getString("Tinh"),rs.getDate("NgSinh"),rs.getString("sdt"));
                return user;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
           
        }
        return null;
    }
     public int LUUTK(String ma,String ten,Date ngaysinh,String noisong,String dt,String quyen)
   {
        int rs = 0;
       try {
           ConnectProvide con = new ConnectProvide();
           con.open();
           String sql = "insert into NhanVien values (?,?,?,?,?,?,?)";
           PreparedStatement pre = con.con.prepareStatement(sql);
           pre.setString(1, ma);
           pre.setString(2, ten);
           pre.setDate(3, (java.sql.Date) ngaysinh);
           pre.setString(4, dt);
           pre.setString(5, ma);
           pre.setString(6, quyen);
           pre.setString(7, noisong);
           rs = pre.executeUpdate();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
      
       return rs;
   }
}
 

