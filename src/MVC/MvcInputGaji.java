
package MVC;
import controler.*;
import view.*;
import model.*;


public class MvcInputGaji {
    ViewInputGaji vinputgaji =new ViewInputGaji();
    ModelInputGaji minputgaji = new ModelInputGaji();
    ControlerInputGaji cpreinputgaji = new ControlerInputGaji(minputgaji,vinputgaji);

}
