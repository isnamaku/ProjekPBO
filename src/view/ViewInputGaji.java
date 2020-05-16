
package view;


import java.awt.Color;
import static java.awt.SystemColor.window;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ViewInputGaji extends JFrame {
     
    JLabel lLembur = new JLabel("lembur / jam : ");
    JTextField tfLembur = new JTextField();
    JLabel lShift = new JLabel ("jumlah shift : ");
    JTextField tfShift = new JTextField();
    JLabel lnik = new JLabel ("nik : ");
    JTextField tfnik = new JTextField();
    JLabel lBulan = new JLabel ("Bulan : ");
    
    public JButton btnTambahPanel = new JButton("Tambah");
    public JButton btnBatalPanel = new JButton("Batal");
    public JButton btnUpdatePanel = new JButton("Update");
    public JButton btnDeletePanel = new JButton("Delete");
    public JButton btnKembaliPanel = new JButton("Kembali");
    String bln[] = {"Januari","Febuary","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};
    public JComboBox<String> Bulan = new JComboBox<String>(bln);  
    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;  //buat scroll
    public Object namaKolom[] = {"ID","NIK","Nama","Bulan","lembur / jam ","shift","Gaji","Bonus"}; //membuat kolom dalam array
    
    
    public ViewInputGaji(){
        setTitle("Input Gaji");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800, 950);
        tableModel = new DefaultTableModel(namaKolom,0); //0 baris
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        //TABEL
        add(scrollPane);
        scrollPane.setBounds(20, 145, 750, 570);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportBorder(new LineBorder(Color.RED));
        scrollPane.getViewport();
        
        
        add(lnik);
        lnik.setBounds(5, 5, 90, 20);
        add(tfnik);
        tfnik.setBounds(110, 5, 120, 20);
        add(lLembur);
        lLembur.setBounds(5, 30, 90, 20);
        add(tfLembur);
        tfLembur.setBounds(110, 30, 120, 20);
        add(lShift);
        lShift.setBounds(5, 55, 90, 20);
        add(tfShift);
        tfShift.setBounds(110, 55, 120, 20);
        
        add(lBulan);
        lBulan.setBounds(250, 5, 90, 20);
        add(Bulan);
        Bulan.setBounds(355, 5, 120, 20);
        
        add(btnTambahPanel);
        btnTambahPanel.setBounds(20, 105, 90, 20);
        
        add(btnBatalPanel);
        btnBatalPanel.setBounds(130, 105, 90, 20);
        
        add(btnDeletePanel);
        btnDeletePanel.setBounds(240, 105, 90, 20);
        
        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(350, 105, 90, 20);
        
        add(btnKembaliPanel);
        btnKembaliPanel.setBounds(650, 5, 90, 20);
        }
    
        public String getLembur(){
        return tfLembur.getText();
        }
        
        public String getShift(){
        return tfShift.getText();
        }
        public String getnik(){
        return tfnik.getText();
        }

}
