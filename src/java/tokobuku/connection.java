/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokobuku;
import java.sql.*;


/**
 *
 * @author Lenovo
 */
public class connection {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String database = "jdbc:mysql://localhost:3306/uas_sahidin";
    private static final String user = "root";
    private static final String password = "";
    private Connection connection;
    private String pesanKesalahan;
    
    public String getPesanKesalahan() {
        return pesanKesalahan;
    }
   
    
    public Connection getConnection() {
        connection = null;
        pesanKesalahan = "";
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            pesanKesalahan = "JDBC Driver tidak ditemukan atau rusak\n" + ex;
        }
            if (pesanKesalahan.equals("")) {
                try {
                connection = DriverManager.getConnection(database + "?user=" + user + "&password="+ password + "");
                System.out.println("suksess konek");
                } catch (SQLException ex) {
            pesanKesalahan = "Koneksi ke " + database + "gagal\n" + ex;
            }
        }
            
        System.out.println(pesanKesalahan);
        return connection;
    }
}


