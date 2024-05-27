/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class ConnectProvide {
    Connection con;
    public void open()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=qltv;encrypt=true;trustServerCertificate=true;";
            String user="saa";
            String password = "1234";
            con = DriverManager.getConnection(url , user , password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void close()
    {
        try {
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public ResultSet executeSQL(String sql)
    {
        ResultSet rs = null;
        try {
            Statement sta = con.createStatement();
           rs =  sta.executeQuery(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
}