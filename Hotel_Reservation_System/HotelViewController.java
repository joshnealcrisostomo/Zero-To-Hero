package Hotel_Reservation_System;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controller for the viewing of hotels.
 */
public class HotelViewController implements ActionListener, DocumentListener {
    private HrsModel model;
    private HotelViewGUI hotelViewGUI;
    private HotelViewMenuGUI hotelViewMenuGUI;
    private MainGUI mainGUI;
    private int hotelIndex;

    /**
     * The sole constructor of HotelViewController
     *
     * @param hotelViewGUI - the GUI/View that asks the user what hotel he/she wants to view
     * @param hotelViewMenuGUI - the GUI/View that handles the viewing options of hotels
     * @param mainGUI - the GUI/View that contains all the GUIs for the program
     * @param model - the model which contains all the logic and processes that makes the program usable.
     */
    public HotelViewController(HotelViewGUI hotelViewGUI, HotelViewMenuGUI hotelViewMenuGUI, MainGUI mainGUI, HrsModel model) {
        this.hotelViewGUI = hotelViewGUI;
        this.hotelViewMenuGUI = hotelViewMenuGUI;
        this.mainGUI = mainGUI;
        this.model = model;

        this.hotelViewGUI.setActionListener(this);
        this.hotelViewMenuGUI.setActionListener(this);
        updateView();
    }

    /**
     * updatedView method that updates the display of hotel list in the GUI
     */
    public void updateView() {
        hotelViewGUI.setHotelList(model.displayHotelList());
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        updateView();

        switch(e.getActionCommand()) {
            case "VIEW HOTEL":
                if(model.hotelExists(hotelViewGUI.getHotelToView())) {
                    hotelIndex = model.hotelChoice(hotelViewGUI.getHotelToView());
                    hotelViewMenuGUI.setViewHotelName(hotelViewGUI.getHotelToView());
                    hotelViewGUI.setInstructionMessage("PROCEEDING TO VIEW MENU");
                    mainGUI.showViewHotelMenuGUI();
                } else {
                    hotelViewGUI.setErrorMessage("HOTEL DOES NOT EXIST");
                }
                break;
            case "High-Level Information":
                hotelViewMenuGUI.updateForHighLvlInfo(model.viewHighLvl(hotelIndex));
                break;
            case "Room Availability For A Selected Date":
                hotelViewMenuGUI.clearTextArea();
                hotelViewMenuGUI.updateForRoomAvail();
                break;
            case "Room Information":
                hotelViewMenuGUI.clearTextArea();
                hotelViewMenuGUI.updateTextArea(model.displayRoom(hotelIndex));
                hotelViewMenuGUI.updateForRoomInfo();
                break;
            case "Reservation Information":
                hotelViewMenuGUI.clearTextArea();
                hotelViewMenuGUI.updateTextArea(model.displayRoom(hotelIndex));
                hotelViewMenuGUI.updateForReservationInfo();
                break;
            case "RETURN TO MAIN MENU":
                hotelViewMenuGUI.clearTextArea();
                mainGUI.showMainMenu();
                break;
            case "APPLY":
                String viewChoice = hotelViewMenuGUI.getViewChoiceLabel();

                switch (viewChoice) {
                    case "ROOM DAY AVAILABILITY":
                        int dateInput = hotelViewMenuGUI.getDateInput();

                        if(model.isDateValid(dateInput)) {
                            String roomAvailabilityInfo = model.roomAvailability(hotelIndex, dateInput);

                            hotelViewMenuGUI.updateTextArea(roomAvailabilityInfo);
                            hotelViewMenuGUI.clearDateInput();
                        } else {
                            hotelViewMenuGUI.setErrorMessage("Invalid date input! Please double check.");
                        }
                        break;
                    case "ROOM INFORMATION":
                        hotelViewMenuGUI.clearTextArea();

                        int roomNum = hotelViewMenuGUI.getRoomInfoInput();

                        if(model.isRoomValid(hotelIndex, roomNum)) {
                            String roomInformation = model.roomInfo(hotelIndex, roomNum);

                            hotelViewMenuGUI.updateTextArea(roomInformation);
                            hotelViewMenuGUI.clearRoomInputFLd();
                        } else {
                            hotelViewMenuGUI.updateTextArea(model.displayRoom(hotelIndex));
                            hotelViewMenuGUI.setErrorMessage("Invalid room number input! Please double check.");
                        }
                        break;
                    case "RESERVATION INFORMATION":
                        hotelViewMenuGUI.clearTextArea();

                        int roomNumInput = hotelViewMenuGUI.getRoomNumInput();
                        String guestName = hotelViewMenuGUI.getGuestName();
                        int checkIn = hotelViewMenuGUI.getCheckInDate();
                        int checkOut = hotelViewMenuGUI.getCheckOutDate();

                        if(model.isRoomValid(hotelIndex, roomNumInput) && model.isDateValid(checkIn) && model.isDateValid(checkOut)) {
                            String resInformation = model.reservationInfo(hotelIndex, roomNumInput, guestName, checkIn, checkOut);

                            hotelViewMenuGUI.updateTextArea(resInformation);
                            hotelViewMenuGUI.clearResFlds();
                        } else {
                            hotelViewMenuGUI.updateTextArea(model.displayRoom(hotelIndex));
                            hotelViewMenuGUI.setErrorMessage("Invalid inputs! Please double check.");
                        }
                        break;
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

