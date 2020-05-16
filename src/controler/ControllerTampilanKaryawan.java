
package controler;

import javax.swing.JOptionPane;
import model.*;
import view.*;

import javax.swing.JTable;

public class ControllerTampilanKaryawan {
    public ControllerTampilanKaryawan(ViewKaryawan view, ModelTampilanKaryawan model) {
            String nik = view.getNIK();
       

        if (model.getBanyakData() != 0) {
            String dataGaji[][] = model.readGaji(nik);
            view.tabel.setModel((new JTable(dataGaji, view.namaKolom)).getModel()); 
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

    }
       
}
