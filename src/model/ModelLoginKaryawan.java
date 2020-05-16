
package model;

import MVC.MvcTampilKaryawan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static model.ModelLoginAdmin.JDBC_DRIVER;

public class ModelLoginKaryawan {
      
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbpenggajian";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;//untuk perintah query
    
    public ModelLoginKaryawan (){
         try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
   }
    
    
    public void loginKaryawan (String nik, String pass){
            try{
                statement = koneksi.createStatement();
                System.out.println(nik);
                System.out.println(pass);
                String sql = "SELECT * FROM karyawan ";
               System.out.println("Sampe sini");
                ResultSet hasil = statement.executeQuery(sql);
                while (hasil.next()){
                System.out.println("perbandingan");
                if(hasil.getString("nik").equals(nik)){
                    System.out.println("sukses nik");
                    if(hasil.getString("password").equals(pass)){
                        System.out.println("sukses");
                        String nk = nik;
                        MvcTampilKaryawan coba = new MvcTampilKaryawan(nk);
                    }
                    else {
                        System.out.println("gagal ps");
                        JOptionPane.showMessageDialog(null,"Password salah");    
                    }
                }
                   
                
            } 
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println("SQL Error");
         
        }
        
    }
    }

