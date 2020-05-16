
package controler;

import model.*;
import view.*;
import MVC.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControlerInputGaji {
    
    ModelInputGaji model;
    ViewInputGaji view;
    public ControlerInputGaji(ModelInputGaji model, ViewInputGaji view) {
        
        this.model = model;
        this.view = view;

        if (model.getBanyakData() != 0) {
            String dataKariawan[][] = model.readGaji();
            view.tabel.setModel((new JTable(dataKariawan, view.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        view.btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lembur = view.getLembur();
                String shift = view.getShift();
                String nik = view.getnik();
                String bln = (String) view.Bulan.getSelectedItem(); 
                model.insertGaji(nik, lembur, shift,bln);
                String dataKariawan[][] = model.readGaji();
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
                    model.deleteGaji(dataterpilih);
                    String dataGaji[][] = model.readGaji();
                    view.tabel.setModel(new JTable(dataGaji, view.namaKolom).getModel());
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
                    if(view.getnik()!= null){
                        /*String nama = view.getNama();
                        }
                        else {
                        String nama = model.readKariawan()
                        }*/
                    String nik= view.getnik();
                    String lembur = view.getLembur();
                    String shift = view.getShift();
                    String bln = (String) view.Bulan.getSelectedItem(); 
                    //String nik = view.getnik();
                    String dataGaji[][] = model.readGaji();
                    model.updateGaji(dataterpilih, nik, lembur, shift , bln);
                    view.tabel.setModel(new JTable(dataGaji, view.namaKolom).getModel());
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
