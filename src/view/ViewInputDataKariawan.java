
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


public class ViewInputDataKariawan extends JFrame {
     
    JLabel lNama = new JLabel("Nama nya : ");
    JTextField tfNama = new JTextField();
    JLabel lAlamat = new JLabel ("alamat : ");
    JTextField tfAlamat = new JTextField();
    JLabel lNO_HP = new JLabel ("NO HP : ");
    JTextField tfNO_HP = new JTextField();
    JLabel lDevisi = new JLabel ("Devisi : ");
    JLabel lnik = new JLabel ("nik : ");
    JTextField tfnik = new JTextField();
    JLabel lps  = new JLabel ("password : ");
    JTextField tfps = new JTextField();
    
    public JButton btnTambahPanel = new JButton("Tambah");
    public JButton btnBatalPanel = new JButton("Batal");
    public JButton btnUpdatePanel = new JButton("Update");
    public JButton btnDeletePanel = new JButton("Delete");
    public JButton btnKembaliPanel = new JButton("Kembali");
    String dvs[] = {"Android Junior","Android Senior","Android Expert","Web Junior","Web Senior","Web Expert","Disain"};
    public JComboBox<String> devisi = new JComboBox<String>(dvs);    
    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;  //buat scroll
    public Object namaKolom[] = {"NIK","Nama","Alamat","NO_HP","Devisi",}; //membuat kolom dalam array
    
    
    public ViewInputDataKariawan(){
        setTitle("Input Data Karyawan");
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
        
        
        add(lNama);
        lNama.setBounds(5, 5, 90, 20);
        add(tfNama);
        tfNama.setBounds(110, 5, 120, 20);
        add(lAlamat);
        lAlamat.setBounds(5, 30, 90, 20);
        add(tfAlamat);
        tfAlamat.setBounds(110, 30, 120, 20);
        add(lNO_HP);
        lNO_HP.setBounds(5, 55, 90, 20);
        add(tfNO_HP);
        tfNO_HP.setBounds(110, 55, 120, 20);
        
        add(lDevisi);
        lDevisi.setBounds(250, 5, 90, 20);
        add(devisi);
        devisi.setBounds(355, 5, 120, 20);
        add(lnik);
        lnik.setBounds(250, 30, 90, 20);
        add(tfnik);
        tfnik.setBounds(355, 30, 120, 20);
        add(lps);
        lps.setBounds(250, 55, 90, 20);
        add(tfps);
        tfps.setBounds(355, 55, 120, 20);
        
        
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
        public String getNama(){
        return tfNama.getText();
        }
        public String getAlamat(){
        return tfAlamat.getText();
        }
        
        public String getNO_HP(){
        return tfNO_HP.getText();
        }
        
        public String getps(){
        return tfps.getText();
        }
        public String getnik(){
        return tfnik.getText();
        }
    
}
