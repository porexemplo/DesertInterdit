import Controller.cController;
import Model.cModel;
import View.cView;

public class Main {
    public static void main(String[] args) {
        cModel theModel = new cModel();
        cView theView = new cView();
        cController theController = new cController(theView, theModel);

        theController.start();
    }
}