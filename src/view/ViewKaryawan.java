
package view;

import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class ViewKaryawan extends JFrame {
    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;  //buat scroll
    public Object namaKolom[] = {"ID","NIK","Nama","Bulan","lembur / jam ","shift","Gaji","Bonus"}; //membuat kolom dalam array
    String nik;
    public ViewKaryawan(String nik) {
        this.nik=nik;
        setTitle("Data Gaji Karyawan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(700, 950);
        tableModel = new DefaultTableModel(namaKolom,0); //0 baris
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        //TABEL
        add(scrollPane);
        scrollPane.setBounds(20, 45, 650, 470);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportBorder(new LineBorder(Color.RED));
        scrollPane.getViewport();
    }
    public String getNIK(){
        
        return nik;
        
    }
        
}
