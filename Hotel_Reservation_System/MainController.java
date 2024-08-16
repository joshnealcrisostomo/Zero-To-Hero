package Hotel_Reservation_System;

/**
 * Main Controller that holds or compiles all subcontrollers.
 */
public class MainController {
    private MainGUI mainGUI;
    private HrsModel model;

    private MainMenuController mainMenuController;
    private CreateHotelController createHotelController;
    private HotelViewController hotelViewController;
    private ManageHotelController manageHotelController;
    private SimulateBookingController simulateBookingController;

    /**
     * The sole constructor of the MainController
     *
     * @param mainGUI - the GUI/View that contains all the GUIs for the program
     * @param model - the model which contains all the logic and processes that makes the program usable.
     */
    public MainController(MainGUI mainGUI, HrsModel model) {
        this.mainGUI = mainGUI;
        this.model = model;

        this.mainMenuController = new MainMenuController(mainGUI.getMainMenuPanel(), this.mainGUI, this.model);
        this.createHotelController = new CreateHotelController(mainGUI.getCreateHotelPanel(), this.mainGUI, this.model);
        this.hotelViewController = new HotelViewController(mainGUI.getHotelViewPanel(), mainGUI.getHotelViewMenuPanel(), this.mainGUI, this.model);
        this.manageHotelController = new ManageHotelController(mainGUI.getManageHotelPanel(), mainGUI.getInManageHotelPanel(), this.mainGUI, this.model);
        this.simulateBookingController = new SimulateBookingController(mainGUI.getSimBookPanel(), this.mainGUI, this.model);
    }
}

