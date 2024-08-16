package Hotel_Reservation_System;

import javax.swing.*;
/**
 * GUI/View that holds or compiles all the sub-GUIs.
 */
public class MainGUI extends JFrame {
    private MainMenuGUI mainMenuPanel;
    private CreateGUI createHotelPanel;
    private HotelViewGUI hotelViewPanel;
    private HotelViewMenuGUI hotelViewMenuPanel;
    private ManageHotelGUI manageHotelPanel;
    private InManageHotelGUI inManageHotelPanel;
    private SimBookGUI simBookPanel;
    private MainController mainController;

    /**
     * The sole constructor of MainGUI class.
     */
    public MainGUI() {
        super("Hotel Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize panels
        mainMenuPanel = new MainMenuGUI(this);
        createHotelPanel = new CreateGUI(this);
        hotelViewPanel = new HotelViewGUI(this);
        hotelViewMenuPanel = new HotelViewMenuGUI(this);
        manageHotelPanel = new ManageHotelGUI(this);
        inManageHotelPanel = new InManageHotelGUI(this);
        simBookPanel = new SimBookGUI(this);

        this.setSize(1400,750);
        this.setResizable(false);

        this.setVisible(true);

        this.setContentPane(mainMenuPanel);
    }

    /**
     * getMainMenuPanel method returns the main menu Panel
     *
     * @return mainMenuPanel
     */
    public MainMenuGUI getMainMenuPanel() {
        return mainMenuPanel;
    }

    /**
     * getCreateHotelPanel method returns the Create hotel Panel
     *
     * @return createHotelPanel
     */
    public CreateGUI getCreateHotelPanel() {
        return createHotelPanel;
    }

    /**
     * getHotelViewPanel method returns the View hotel Panel
     *
     * @return hotelViewPanel
     */
    public HotelViewGUI getHotelViewPanel() {
        return hotelViewPanel;
    }

    /**
     * getHotelViewMenuPanel method returns the View Menu hotel Panel
     *
     * @return hotelViewMenuPanel
     */
    public HotelViewMenuGUI getHotelViewMenuPanel() {
        return hotelViewMenuPanel;
    }

    /**
     * getManageHotelPanel method returns the Manage hotel Panel
     *
     * @return manageHotelPanel
     */
    public ManageHotelGUI getManageHotelPanel() {
        return manageHotelPanel;
    }

    /**
     * getInManageHotelPanel method returns the Manage Menu hotel Panel
     *
     * @return inManageHotelPanel
     */
    public InManageHotelGUI getInManageHotelPanel() {
        return inManageHotelPanel;
    }

    /**
     * getSimBookPanel method returns the Sim Book Panel
     *
     * @return simBookPanel
     */
    public SimBookGUI getSimBookPanel() {
        return simBookPanel;
    }

    /**
     * showMainMenu method shows the main menu panel
     */
    public void showMainMenu() {
        setContentPane(mainMenuPanel);
        revalidate();
    }

    /**
     * showCreateHotelGUI method shows the Create hotel panel
     */
    public void showCreateHotelGUI() {
        setContentPane(createHotelPanel);
        revalidate();
    }

    /**
     * showViewHotelGUI method shows the View hotel panel
     */
    public void showViewHotelGUI() {
        setContentPane(hotelViewPanel);
        revalidate();
    }

    /**
     * showViewHotelMenuGUI method shows the View hotel menu panel
     */
    public void showViewHotelMenuGUI() {
        setContentPane(hotelViewMenuPanel);
        revalidate();
    }

    /**
     * showManageHotelGUI method shows the manage hotel panel
     */
    public void showManageHotelGUI() {
        setContentPane(manageHotelPanel);
        revalidate();
    }

    /**
     * showInManageHotelGUI method shows the in manage hotel panel
     */
    public void showInManageHotelGUI() {
        setContentPane(inManageHotelPanel);
        revalidate();
    }

    /**
     * showSimBookGUI method shows the sim book panel
     */
    public void showSimBookGUI() {
        setContentPane(simBookPanel);
        revalidate();
    }
}

