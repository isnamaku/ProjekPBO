
package mvc;
 
import view.*;
import model.*;
import controler.*;


public class MvcAdmin {
    ViewLoginAdmin viewLoginAdmin = new ViewLoginAdmin();
    ModelLoginAdmin modelLogin = new ModelLoginAdmin();
    ControllerLoginAdmin controllerAdmin = new ControllerLoginAdmin (viewLoginAdmin,modelLogin);
}