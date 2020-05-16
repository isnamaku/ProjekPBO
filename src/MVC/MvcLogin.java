
package mvc;
import view.*;
import controler.*;


public class MvcLogin {
    ViewLogin viewLogin = new ViewLogin();
   // Model modelLogin = new Model();
    ControllerLogin controllerLogin = new ControllerLogin (viewLogin);//,modelLogin);
    
}
