package Hotel_Reservation_System;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controller for the creation of hotels.
 */
public class CreateHotelController implements ActionListener, DocumentListener {
    private HrsModel model;
    private CreateGUI createGUI;
    private MainGUI mainGUI;
    private int numHotels;
    private int currentHotelIndex = 0;

    /**
     * The sole constructor of CreateHotelController
     *
     * @param createGUI - the GUI/View that handles the creation of hotels
     * @param mainGUI - the GUI/View that contains all the GUIs for the program
     * @param model - the model which contains all the logic and processes that makes the program usable.
     */
    public CreateHotelController(CreateGUI createGUI, MainGUI mainGUI, HrsModel model) {
        this.createGUI = createGUI;
        this.mainGUI = mainGUI;
        this.model = model;

        updateView();

        this.createGUI.setActionListener(this);
    }

    /**
     * updatedView method that updates the number of hotels to be created and the display of hotel list in the GUI
     */
    public void updateView() {
        createGUI.setHotelList(model.displayHotelList());
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "RETURN TO MAIN MENU":
                createGUI.clearInputFields();
                mainGUI.showMainMenu();
                break;
            case "ENTER":
                numHotels = createGUI.getNumOfHotel();

                if(numHotels > 0) {
                    createGUI.setInstructionMessage("Enter details for the Hotel 1");
                    currentHotelIndex = 0;
                    updateView();
                    createGUI.disableEnterBtn();
                } else {
                    createGUI.setErrorMessage("Please enter a valid number of hotels.");
                    createGUI.clearHotelFld();
                }
                break;
            case "APPLY":
                if(numHotels > 0 && currentHotelIndex < numHotels) {
                    String hotelName = createGUI.getHotelName();
                    int stdRooms = createGUI.getStandardRooms();
                    int dlxRooms = createGUI.getDeluxeRooms();
                    int exeRooms = createGUI.getExecutiveRooms();

                    if(stdRooms < 0 || dlxRooms < 0 || exeRooms < 0) {
                        createGUI.setErrorMessage("Invalid room input! Please double check.");
                    } else {
                        boolean isHotelCreated = model.createHotel(hotelName, stdRooms, dlxRooms, exeRooms);

                        if (isHotelCreated) {
                            createGUI.setInstructionMessage("Hotel " + (currentHotelIndex + 1) + " was successfully created!");
                            currentHotelIndex++;
                            createGUI.clearInputFields();
                            updateView();

                            if (currentHotelIndex < numHotels) {
                                createGUI.setInstructionMessage("Enter details for Hotel " + (currentHotelIndex + 1));
                            } else {
                                createGUI.setHotelList(model.displayHotelList());
                                createGUI.setInstructionMessage("All hotels have been created.");
                                createGUI.clearHotelFld();
                                createGUI.enableEnterBtn();
                            }
                        } else {
                            createGUI.setErrorMessage("Failed to create hotel! Check input values.");
                        }
                    }
                } else {
                    createGUI.setErrorMessage("Please enter the number of hotels first!");
                    createGUI.clearInputFields();
                }
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
