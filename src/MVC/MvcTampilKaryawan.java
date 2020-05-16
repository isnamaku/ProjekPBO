
package MVC;
import view.*;
import controler.*;
import model.*;


public class MvcTampilKaryawan {
    
    public MvcTampilKaryawan(String nik) {
        ViewKaryawan view = new ViewKaryawan(nik);
        ModelTampilanKaryawan mview = new ModelTampilanKaryawan();
        ControllerTampilanKaryawan controler = new ControllerTampilanKaryawan(view,mview);
    }
    
    
}
