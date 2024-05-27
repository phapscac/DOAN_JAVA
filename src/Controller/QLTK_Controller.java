/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/** 
 * @author Admin
 */
public class QLTK_Controller {
     public ArrayList<User> listStu()
   {
       ArrayList<User> list = new ArrayList<User>();
       ConnectProvide con = new ConnectProvide();
       con.open();
       String sql = "select MaNV,Hoten,quyen,Tinh,NgSinh,sdt from NhanVien where quyen='nv'";
       ResultSet rs =  con.executeSQL(sql);
       try {
           while(rs.next())
           {
                String maNV = rs.getString("MaNV");
                String hoTen = rs.getString("Hoten");
                String quyen = rs.getString("quyen");
                String Tinh = rs.getString("Tinh");
                Date ngSinh = rs.getDate("NgSinh");
                String sdt = rs.getString("sdt");
                 
               User u = new User(maNV, hoTen, quyen, Tinh, ngSinh, sdt);
                list.add(u);
           }
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
       return list;
   } 
     public int Update( String maso,String hoten,String Tinh,String pass,String sodt)     
     {
          int rs = 0;
       try {
           ConnectProvide con = new ConnectProvide();
           con.open();
           String sql = "update NhanVien set Hoten = ?,Tinh=?,sdt =? where maNV =?";
           PreparedStatement pre = con.con.prepareStatement(sql);
           pre.setString(1, hoten);
           pre.setString(2, Tinh);
           pre.setString(3, sodt);
           pre.setString(4, maso);
         
           rs = pre.executeUpdate();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return rs;
   }
       public int doimk( String maso,String pass,String mkcu)     
     {
          int rs = 0;
       try {
           ConnectProvide con = new ConnectProvide();
           con.open();
           String sql = "update NhanVien set matkhau = ? where maNV =? and matkhau = ?";
           PreparedStatement pre = con.con.prepareStatement(sql);
           pre.setString(1, pass);
           pre.setString(2, maso);
           pre.setString(3, mkcu);
           rs = pre.executeUpdate();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return rs;
   }
      public int XoaTK(String maNV)
         {
          int rs = 0;
       try {
           ConnectProvide con = new ConnectProvide();
           con.open();
           String sql = "Delete from NhanVien where maNV =?";
           PreparedStatement pre = con.con.prepareStatement(sql);
           pre.setString(1, maNV);
         
           rs = pre.executeUpdate();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return rs;
   }     
     public int ReSetPass(String maNV)
         {
          int rs = 0;
       try {
           ConnectProvide con = new ConnectProvide();
           con.open();
           String sql = "update NhanVien set matkhau = ? where maNV =?";
           PreparedStatement pre = con.con.prepareStatement(sql);
           pre.setString(1, maNV);
         pre.setString(2, maNV);
           rs = pre.executeUpdate();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return rs;
   }     
}
