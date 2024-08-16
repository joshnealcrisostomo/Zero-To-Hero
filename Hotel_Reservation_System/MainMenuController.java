package Hotel_Reservation_System;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controller for the main menu.
 */
public class MainMenuController implements ActionListener, DocumentListener {
    private MainMenuGUI mainMenuGui;
    private MainGUI mainGUI;
    private HrsModel model;

    /**
     * The sole constructor of the MainMenuController
     *
     * @param mainMenuGui - the GUI/View that holds the options to create hotels, view hotels, manage hotels, and simulate a booking
     * @param mainGUI - the GUI/View that contains all the GUIs for the program
     * @param model - the model which contains all the logic and processes that makes the program usable.
     */
    public MainMenuController(MainMenuGUI mainMenuGui, MainGUI mainGUI, HrsModel model) {
        this.model = model;
        this.mainMenuGui = mainMenuGui;
        this.mainGUI = mainGUI;

        this.mainMenuGui.setActionListener(this);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "CREATE A HOTEL":
                mainGUI.getCreateHotelPanel().setHotelList(model.displayHotelList());
                mainGUI.showCreateHotelGUI();
                break;
            case "VIEW A HOTEL":
                if(model.isHotelListEmpty()) {
                    mainMenuGui.setErrorMessage("ERROR: There are no hotels!");
                    return;
                } else {
                    mainGUI.getHotelViewPanel().setHotelList(model.displayHotelList());
                    mainGUI.showViewHotelGUI();
                }
                break;
            case "MANAGE A HOTEL":
                if(model.isHotelListEmpty()) {
                    mainMenuGui.setErrorMessage("ERROR: There are no hotels!");
                    return;
                } else {
                    mainGUI.getManageHotelPanel().setHotelList(model.displayHotelList());
                    mainGUI.showManageHotelGUI();
                }
                break;
            case "SIMULATE BOOKING":
                if(model.isHotelListEmpty()) {
                    mainMenuGui.setErrorMessage("ERROR: There are no hotels!");
                    return;
                } else {
                    mainGUI.getSimBookPanel().setHotelList(model.displayHotelList());
                    mainGUI.showSimBookGUI();
                }
                break;
        }
    }

    /**
     * Gives notification that there was an insert into the document.  The
     * range given by the DocumentEvent bounds the freshly inserted region.
     *
     * @param e the document event
     */
    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    /**
     * Gives notification that a portion of the document has been
     * removed.  The range is given in terms of what the view last
     * saw (that is, before updating sticky positions).
     *
     * @param e the document event
     */
    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    /**
     * Gives notification that an attribute or set of attributes changed.
     *
     * @param e the document event
     */
    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}

