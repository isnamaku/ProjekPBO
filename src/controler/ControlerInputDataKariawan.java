
package controler;

import model.*;
import view.*;
import MVC.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControlerInputDataKariawan {
    ModelInputDataKariawan model;
    ViewInputDataKariawan view;
    public ControlerInputDataKariawan(ModelInputDataKariawan model, ViewInputDataKariawan view) {
   
        this.model = model;
        this.view = view;

        if (model.getBanyakData() != 0) {
            String dataKariawan[][] = model.readKariawan();
            view.tabel.setModel((new JTable(dataKariawan, view.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        view.btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = view.getNama();
                String no = view.getNO_HP();
                String alamat = view.getAlamat();
                String nik = view.getnik();
                String ps = view.getps();
                String dv = (String) view.devisi.getSelectedItem(); 
                model.insertKariawan(nama, alamat, no, nik, ps, dv);

                String dataKariawan[][] = model.readKariawan();
                view.tabel.setModel(new JTable(dataKariawan, view.namaKolom).getModel());
            }
        });
        
        view.btnDeletePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int baris = view.tabel.getSelectedRow();
                int kolom = view.tabel.getSelectedColumn();

                String dataterpilih = view.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus NAMA" + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    model.deleteKariawan(dataterpilih);
                    String dataKariawan[][] = model.readKariawan();
                    view.tabel.setModel(new JTable(dataKariawan, view.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
        
        view.btnUpdatePanel.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int baris = view.tabel.getSelectedRow();
                int kolom = view.tabel.getSelectedColumn();

                String dataterpilih = view.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin UPDATE NIK" + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) { 
                    if(view.getNama()!= null){
                        
                    String nama = view.getNama();
                    String no = view.getNO_HP();
                    String alamat = view.getAlamat();
         
                    String ps = view.getps();
                    String dv = (String) view.devisi.getSelectedItem();;
                    String dataKariawan[][] = model.readKariawan();
                    model.updateKariawan(dataterpilih, nama, alamat, no, ps, dv);
                    view.tabel.setModel(new JTable(dataKariawan, view.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }  
    });
        view.btnKembaliPanel.addActionListener(new  ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setVisible(false);
                MvcPreInputGaji back = new MvcPreInputGaji();
            }
        });
  }  
}
