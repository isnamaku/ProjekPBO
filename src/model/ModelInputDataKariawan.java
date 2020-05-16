
package model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class ModelInputDataKariawan {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbpenggajian";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelInputDataKariawan() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    public String[][] readKariawan() {
        try{
            int jmlData = 0;//menampung jumlah data
            
            String data[][] = new String[getBanyakData()][5]; //baris, kolom nya ada 3
            
            String query = "SELECT * FROM `karyawan` JOIN `divisi` WHERE karyawan.id_divisi = divisi.id ORDER BY `karyawan`.`nik` ASC";// ORDER BY `mahasiswa`.`NIM` ASC";pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("nik"); //kolom nama harus sama besar kecilnya dgn database
                data[jmlData][1] = resultSet.getString("karyawan.nama");                
                data[jmlData][2] = resultSet.getString("karyawan.alamat");              
                data[jmlData][3] = resultSet.getString("karyawan.NO_HP");             
                data[jmlData][4] = resultSet.getString("divisi.nama");
                jmlData++; //barisnya berpindah terus
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
}   
    public int getBanyakData() {
        int jmlData = 0;
       try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `karyawan` JOIN `divisi` WHERE karyawan.id_divisi = divisi.id"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void insertKariawan(String nama, String alamat, String no, String nik, String ps, String dv) {
         try {
            String id_dv  = getIddevisi(dv);
             
            String input = "INSERT INTO `karyawan` (`nik`, `password`, `nama`, `no_hp`, `alamat`, `id_divisi`) VALUES ('"+nik+"','"+ps+"','"+nama+"','"+no+"','"+alamat+"' ,'"+id_dv+"')";//value 1 (id diskip)
           
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(input); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void deleteKariawan(String dataterpilih) {
        try{
            String query = "DELETE FROM `karyawan` WHERE `nik` = '"+dataterpilih+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void updateKariawan(String Dataterpilih, String nama, String alamat, String no,  String ps, String dv) {
        try {
            String id_dv = getIddevisi(dv);
            
        String query = "UPDATE karyawan SET password ='"+ps+"', nama = '"+nama+"', no_hp = '"+no+"', alamat = '"+alamat+"' ,id_divisi = '"+id_dv+"'WHERE nik ='"+Dataterpilih+"' ";
        statement = (Statement) koneksi.createStatement();
           statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil diupdate");
            JOptionPane.showMessageDialog(null, "Data Update");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String getIddevisi(String dv) {
        try {
            statement = koneksi.createStatement();
            String sql = "SELECT * FROM `divisi` ";
            ResultSet hasil = statement.executeQuery(sql);
            String id_dv = null;
            int j = 0;
            while (hasil.next()){
            if(hasil.getString("nama").equals(dv) ){
            System.out.println(dv);
            id_dv = hasil.getString("id");
            }
            j++;
            System.out.println(j);
            System.out.println(hasil.getString("nama"));
            System.out.println(dv);
            }
            System.out.println(id_dv);
            return id_dv;
            }
            catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            }
        return null;
        }
            
    }

