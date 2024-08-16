package Hotel_Reservation_System;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controller for the booking simulation.
 */
public class SimulateBookingController implements ActionListener, DocumentListener {
    private SimBookGUI simBookGUI;
    private MainGUI mainGUI;
    private HrsModel model;
    private int hotelIndex;

    /**
     * The sole constructor of SimulateBookingController
     *
     * @param simBookGUI - the GUI?View that contains the fields to fill up when booking
     * @param mainGUI - the GUI/View that contains all the GUIs for the program
     * @param model - the model which contains all the logic and processes that makes the program usable.
     */
    public SimulateBookingController(SimBookGUI simBookGUI, MainGUI mainGUI, HrsModel model) {
        this.mainGUI = mainGUI;
        this.simBookGUI = simBookGUI;
        this.model = model;

        this.simBookGUI.setActionListener(this);
        updateView();
    }

    /**
     * updatedView method that updates the display of hotel list in the GUI
     */
    public void updateView() {
        simBookGUI.setHotelList(model.displayHotelList());
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        updateView();

        switch (e.getActionCommand()) {
            case "ENTER":
                if(model.hotelExists(simBookGUI.getHotelName())) {
                    hotelIndex = model.hotelChoice(simBookGUI.getHotelName());
                    simBookGUI.setInstructionMessage("Hotel Exists. Please enter the reservation details.");

                    simBookGUI.clearTextArea();
                    simBookGUI.setTextAreaLabel("ROOM LIST");
                    simBookGUI.updateTextArea(model.displayRoom(hotelIndex));

                    simBookGUI.setLabel4(simBookGUI.getHotelName());
                } else {
                    simBookGUI.setErrorMessage("HOTEL DOES NOT EXIST");
                }
                simBookGUI.clearInputFields();
                break;
            case "BOOK":
                simBookGUI.clearTextArea();
                simBookGUI.setTextAreaLabel("RECEIPT");

                String guestName = simBookGUI.getGuestName();
                String roomType = simBookGUI.getRoomType();
                int roomNumber = simBookGUI.getRoomNumber();
                int checkIn = simBookGUI.getCheckIn();
                int checkOut = simBookGUI.getCheckOut();
                String discountCode = simBookGUI.getDiscountCode();

                roomType = roomType.toUpperCase();

                if(model.isRoomValid(hotelIndex, roomNumber) && model.isDateValid(checkIn) && model.isDateValid(checkOut)) {
                    if(!discountCode.equals("I_WORK_HERE") && !discountCode.equals("STAY4_GET1") && !discountCode.equals("PAYDAY") && !discountCode.isEmpty()) {
                        simBookGUI.updateTextArea(model.displayRoom(hotelIndex));
                        simBookGUI.setErrorMessage("DISCOUNT CODE IS INVALID");
                        return;
                    }

                    if(roomType.equals("STANDARD") || roomType.equals("DELUXE") || roomType.equals("EXECUTIVE")) {
                        String resPreview = model.previewReservation(guestName, roomNumber, checkIn, checkOut, model.getHotelBasePrice(hotelIndex), roomType);
                        simBookGUI.updateTextArea(resPreview);

                        int confirmation = simBookGUI.showConfirmationMessage();

                        if(confirmation == simBookGUI.getYesOption()) {
                            String reservationMade = model.bookingSimulation(hotelIndex, guestName, roomType, roomNumber, checkIn, checkOut, discountCode);
                            simBookGUI.handleYesChangeOption();
                            simBookGUI.updateTextArea(reservationMade);
                        } else if(confirmation == simBookGUI.getNoOption()) {
                            simBookGUI.handleNoChangeOption();
                        }
                    } else {
                        simBookGUI.updateTextArea(model.displayRoom(hotelIndex));
                        simBookGUI.setErrorMessage("Invalid inputs! Please double check.");
                    }
                } else {
                    simBookGUI.updateTextArea(model.displayRoom(hotelIndex));
                    simBookGUI.setErrorMessage("Invalid inputs! Please double check.");
                }
                break;
            case "RETURN TO MAIN MENU":
                simBookGUI.clearTextArea();
                simBookGUI.clearInputFields();
                mainGUI.showMainMenu();
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

