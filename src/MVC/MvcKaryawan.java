
package mvc;

import controler.ControllerLoginKaryawan;
import model.ModelLoginKaryawan;
import view.ViewLoginKaryawan;


public class MvcKaryawan {
    
    ModelLoginKaryawan modelKaryawan = new ModelLoginKaryawan ();
    ViewLoginKaryawan viewKaryawan = new ViewLoginKaryawan ();
    ControllerLoginKaryawan controllerKaryawan = new ControllerLoginKaryawan (viewKaryawan,modelKaryawan);
    
    
    
}
