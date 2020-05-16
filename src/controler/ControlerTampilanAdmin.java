
package controler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import MVC.*;


public class ControlerTampilanAdmin {
    ViewTampilanAdmin PreInputGaji;
    public ControlerTampilanAdmin(ViewTampilanAdmin view) {
       view.btnLihatPanel.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
              view.setVisible(false);
              MvcInputGaji gaji = new MvcInputGaji();
           }
       });
       view.btnInputPanel.addActionListener(new ActionListener (){
           @Override
           public void actionPerformed(ActionEvent ae) {
               view.setVisible(false);
               MvcInputDataKariawan input = new MvcInputDataKariawan();
              
           }
       });
       
    }
    
}
