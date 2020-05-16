
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ModelLoginKaryawan;
import mvc.MvcLogin;
import view.ViewLoginKaryawan;


public class ControllerLoginKaryawan {
ViewLoginKaryawan view;
ModelLoginKaryawan model;
    public ControllerLoginKaryawan(ViewLoginKaryawan viewKaryawan, ModelLoginKaryawan modelKaryawan) {
        this.view = viewKaryawan;
        this.model = modelKaryawan;
        
        
      view.btnMasukKaryawan.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent ae) {
                   String pass = view.getTfPassKaryawan();
                   String nik = view.getTfNikKaryawan();
               
               model.loginKaryawan(nik, pass);
             
            }
          
          
          
      });
      
        view.btnKembaliKaryawan.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setVisible(false);
                MvcLogin login = new MvcLogin();
            }

    });
    }
    
}
