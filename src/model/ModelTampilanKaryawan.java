
package model;

import controler.ControllerTampilanKaryawan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import view.ViewKaryawan;

public class ModelTampilanKaryawan {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbpenggajian";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    String nik;

   public ModelTampilanKaryawan() {
         try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
            }
        
        }
    public int getBanyakData(){
       int jmlData = 0;
       try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `karyawan` JOIN `gaji` WHERE karyawan.nik = gaji.nik_sasaran"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                  jmlData++;  
             }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
       return 0;
    }


    public String[][] readGaji(String nik) {
        try{
        int jmlData = 0;//menampung jumlah data
            
            String data[][] = new String[getBanyakData()][8]; //baris, kolom nya ada 3
            String query = "SELECT * FROM `karyawan` JOIN `gaji` WHERE karyawan.nik = gaji.nik_sasaran ORDER BY `karyawan`.`nik` ASC";// ORDER BY `mahasiswa`.`NIM` ASC";pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()){ 
               if(resultSet.getString("gaji.nik_sasaran").equals(nik)){
                    data[jmlData][0] = resultSet.getString("id");
                    data[jmlData][1] = resultSet.getString("karyawan.nik"); //kolom nama harus sama besar kecilnya dgn database
                    data[jmlData][2] = resultSet.getString("karyawan.nama");                
                    data[jmlData][3] = resultSet.getString("gaji.bulan");               
                    data[jmlData][4] = resultSet.getString("gaji.durasi_lembur");              
                    data[jmlData][5] = resultSet.getString("gaji.durasi_kerja");             
                    data[jmlData][6] = resultSet.getString("gaji.gaji");            
                    data[jmlData][7] = resultSet.getString("gaji.bonus");
               }
                jmlData++; //barisnya berpindah terus
            }return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
        
    }
}
