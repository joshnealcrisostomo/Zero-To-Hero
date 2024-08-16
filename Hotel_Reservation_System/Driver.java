package Hotel_Reservation_System;

/**
 * Main driver of the program.
 */
public class Driver {
    public static void main(String[] args) {
        HrsModel model = new HrsModel();
        MainGUI mainGUI = new MainGUI();
        MainController mainController = new MainController(mainGUI, model);
    }
}
