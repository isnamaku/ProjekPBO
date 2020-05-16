
package MVC;

import controler.*;
import model.*;
import view.*;


public class MvcInputDataKariawan {
    ViewInputDataKariawan vinputgaji =new ViewInputDataKariawan();
    ModelInputDataKariawan minputgaji = new ModelInputDataKariawan();
    ControlerInputDataKariawan cpreinputgaji = new ControlerInputDataKariawan(minputgaji,vinputgaji);

    
}
