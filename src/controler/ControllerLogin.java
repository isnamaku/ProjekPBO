
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import model.*;
import mvc.*;


public class ControllerLogin {
 ModelLoginAdmin model;
 ViewLogin view;
    
    public ControllerLogin(ViewLogin viewLogin){//, Model modelLogin) {
       // this.model = modelLogin;
        this.view = viewLogin;
        view.btnLoginAdmin.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent ae) {
               view.setVisible(false);
               MvcAdmin loginadmin = new MvcAdmin();
            }  
        });
        
         view.btnLoginKaryawan.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setVisible(false);
               MvcKaryawan loginKaryawan = new MvcKaryawan();
                
            }  
        });
        
    }
}
