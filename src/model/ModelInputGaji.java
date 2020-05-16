
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelInputGaji {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbpenggajian";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    public ModelInputGaji(){
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
            return 0;
        }
    }

    public String[][] readGaji() {
        try{
        int jmlData = 0;//menampung jumlah data
            
            String data[][] = new String[getBanyakData()][8]; //baris, kolom nya ada 3
            
            String query = "SELECT * FROM `karyawan` JOIN `gaji` WHERE karyawan.nik = gaji.nik_sasaran ORDER BY `karyawan`.`nik` ASC";// ORDER BY `mahasiswa`.`NIM` ASC";pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("gaji.id");
                data[jmlData][1] = resultSet.getString("karyawan.nik"); //kolom nama harus sama besar kecilnya dgn database
                data[jmlData][2] = resultSet.getString("karyawan.nama");                
                data[jmlData][3] = resultSet.getString("gaji.bulan");               
                data[jmlData][4] = resultSet.getString("gaji.durasi_lembur");              
                data[jmlData][5] = resultSet.getString("gaji.durasi_kerja");             
                data[jmlData][6] = resultSet.getString("gaji.gaji");            
                data[jmlData][7] = resultSet.getString("gaji.bonus");
                jmlData++; //barisnya berpindah terus
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insertGaji(String nik, String lembur, String shift ,String bln) {
        try{
            String getiddevisi = getIdDevsis(nik);
            String biayalembur = getBiayaLembur(getiddevisi);
            String biayaperjam = getBiayaPerJam(getiddevisi);
            double biayalmbr = Double.parseDouble(biayalembur);
            double perjam = Double.parseDouble(biayaperjam);
            int lmbr = Integer.parseInt(lembur);
            int shft = Integer.parseInt(shift);
            double gaji = (perjam * 6)* shft ;
            double bonus = biayalmbr * lmbr;
            String input = "INSERT INTO `gaji` (`bulan`,`nik_admin`, `nik_sasaran`, `id_divisi`, `durasi_kerja`, `durasi_lembur`, `gaji`, `bonus`) VALUES ('"+bln+"', '10001','"+nik+"', '"+getiddevisi+"', '"+shift+"', '"+lembur+"', '"+gaji+"', '"+bonus+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(input); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil");
        } 
        catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void deleteGaji(String dataterpilih) {
        try{
            String query = "DELETE FROM `gaji` WHERE `id` = '"+dataterpilih+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void updateGaji(String Dataterpilih, String nik, String lembur, String shift ,String bln) {
        try{
            String getiddevisi = getIdDevsis(nik);
            String biayalembur = getBiayaLembur(getiddevisi);
            String biayaperjam = getBiayaPerJam(getiddevisi);
            double biayalmbr = Double.parseDouble(biayalembur);
            double perjam = Double.parseDouble(biayaperjam);
            int lmbr = Integer.parseInt(lembur);
            int shft = Integer.parseInt(shift);
            double gaji = (perjam * 6)* shft ;
            double bonus = biayalmbr * lmbr;
        
            String query = "UPDATE gaji SET bulan ='"+bln+"', nik_sasaran = '"+nik+"', id_divisi = '"+getiddevisi+"', durasi_kerja = '"+shift+"' ,durasi_lembur = '"+lembur+"' ,gaji = '"+gaji+"' ,bonus = '"+bonus+"' WHERE id ='"+Dataterpilih+"' ";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil di Update");
            JOptionPane.showMessageDialog(null, "Data Berhasil");
        } 
        catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    private String getIdDevsis(String nik) throws SQLException {
        System.out.println("get divisi");
        statement = koneksi.createStatement();
        String sql = "SELECT * FROM `karyawan` ";
        ResultSet hasil = statement.executeQuery(sql);
        String id = null;
            while (hasil.next()){
                if(hasil.getString("nik").equals(nik) ){
                id = hasil.getString("id_divisi");  
                }
            }
        return id;
    }

    private String getBiayaLembur(String iddevisi) throws SQLException {
        System.out.println("getbiaya");
        statement = koneksi.createStatement();
        String sql = "SELECT * FROM `divisi`";
        ResultSet hasil = statement.executeQuery(sql);
        String biaya = null;
        while (hasil.next()){
                if(hasil.getString("id").equals(iddevisi) ){
                biaya = hasil.getString("lembur");  
                }
            }
        return biaya;
        
    }

    private String getBiayaPerJam(String iddevisi) throws SQLException {
        System.out.println("get perjam");
        statement = koneksi.createStatement();
        String sql = "SELECT * FROM `divisi` ";
        ResultSet hasil = statement.executeQuery(sql);String biaya = null;
        while (hasil.next()){
                if(hasil.getString("id").equals(iddevisi) ){
                biaya = hasil.getString("gaji_perjam");  
                }
            }
        return biaya;
       
    }
    
}
