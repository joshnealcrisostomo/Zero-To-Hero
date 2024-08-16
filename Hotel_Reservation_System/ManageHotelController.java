package Hotel_Reservation_System;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controller for the management of hotels.
 */
public class ManageHotelController implements ActionListener, DocumentListener {
    private HrsModel model;
    private MainGUI mainGUI;
    private ManageHotelGUI manageHotelGUI;
    private InManageHotelGUI inManageHotelGUI;
    private int hotelIndex;

    /**
     * The sole constructor of the ManageHotelController
     *
     * @param manageHotelGUI - the GUI/View that asks the user what hotel he/she wants to manage
     * @param inManageHotelGUI - the GUI/View that handles the manage options of hotels
     * @param mainGUI - the GUI/View that contains all the GUIs for the program
     * @param model - the model which contains all the logic and processes that makes the program usable.
     */
    public ManageHotelController(ManageHotelGUI manageHotelGUI, InManageHotelGUI inManageHotelGUI, MainGUI mainGUI, HrsModel model) {
        this.mainGUI = mainGUI;
        this.manageHotelGUI = manageHotelGUI;
        this.inManageHotelGUI = inManageHotelGUI;
        this.model = model;

        this.manageHotelGUI.setActionListener(this);
        this.inManageHotelGUI.setActionListener(this);
        updateView();
    }

    /**
     * updatedView method that updates the display of hotel list in the GUI
     */
    public void updateView() {
        manageHotelGUI.setHotelList(model.displayHotelList());
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
            case "MANAGE HOTEL":
                if(model.hotelExists(manageHotelGUI.getHotelToManage())) {
                    hotelIndex = model.hotelChoice(manageHotelGUI.getHotelToManage());
                    inManageHotelGUI.setManageHotelName(manageHotelGUI.getHotelToManage());
                    manageHotelGUI.setInstructionMessage("PROCEEDING TO MANAGE MENU");
                    mainGUI.showInManageHotelGUI();
                } else {
                    manageHotelGUI.setErrorMessage("HOTEL DOES NOT EXIST");
                }
                break;
            case "Change Hotel Name":
                inManageHotelGUI.clearTextArea();
                inManageHotelGUI.updateForChangeHotelName();
                break;
            case "Add Room":
                inManageHotelGUI.clearTextArea();
                inManageHotelGUI.updateTextArea(model.displayRoom(hotelIndex));
                inManageHotelGUI.updateForAddRoom();
                break;
            case "Update Base Price":
                inManageHotelGUI.clearTextArea();
                inManageHotelGUI.updateForBasePrice();
                break;
            case "Remove Room":
                inManageHotelGUI.clearTextArea();
                inManageHotelGUI.updateTextArea(model.displayRoom(hotelIndex));
                inManageHotelGUI.updateForRemoveRoom();
                break;
            case "Remove Reservation":
                inManageHotelGUI.clearTextArea();
                inManageHotelGUI.updateTextArea(model.displayRoom(hotelIndex));
                inManageHotelGUI.updateForRemoveRes();
                break;
            case "Remove Hotel":
                inManageHotelGUI.clearTextArea();
                inManageHotelGUI.updateForRemoveHotel();

                int removeHotelConfirmation = inManageHotelGUI.showConfirmRemoveHotel();

                if(removeHotelConfirmation == inManageHotelGUI.getYesOption()) {
                    String removeHotelStatus = model.removeHotel(hotelIndex);

                    inManageHotelGUI.updateTextArea(removeHotelStatus);
                    inManageHotelGUI.handleYesChangeOption();
                    mainGUI.showMainMenu();
                } else if (removeHotelConfirmation == inManageHotelGUI.getNoOption()) {
                    inManageHotelGUI.handleNoChangeOption();
                }

                break;
            case "Date Price Modifier":
                inManageHotelGUI.clearTextArea();
                inManageHotelGUI.updateTextArea(model.displayDatePrice(hotelIndex));
                inManageHotelGUI.updateForDatePriceMod();
                break;
            case "RETURN TO MAIN MENU":
                inManageHotelGUI.clearTextArea();
                mainGUI.showMainMenu();
                break;
            case "ENTER":
                int confirmation;
                String manageChoice = inManageHotelGUI.getManageChoiceLabel();

                switch(manageChoice) {
                    case "CHANGE HOTEL NAME:":
                        confirmation = inManageHotelGUI.showConfirmationMessage();

                        if(confirmation == inManageHotelGUI.getYesOption()) {
                            String newHotelName = inManageHotelGUI.getHotelName();

                            if(model.hotelExists(newHotelName)) {
                                inManageHotelGUI.setErrorMessage("INVALID! Hotel Name already exists.");
                            } else {
                                String changeHotelNameStatus = model.changeHotelName(hotelIndex, newHotelName);
                                inManageHotelGUI.updateTextArea(changeHotelNameStatus);
                                inManageHotelGUI.handleYesChangeOption();
                                inManageHotelGUI.setManageHotelName(newHotelName);
                            }
                            inManageHotelGUI.clearHotelNameFld();
                        } else if (confirmation == inManageHotelGUI.getNoOption()) {
                            inManageHotelGUI.clearTextArea();
                            inManageHotelGUI.handleNoChangeOption();
                        }
                        break;
                    case "ADD ROOMS:":
                        inManageHotelGUI.clearTextArea();

                        confirmation = inManageHotelGUI.showConfirmationMessage();

                        if(confirmation == inManageHotelGUI.getYesOption()) {
                            int roomsToAdd = inManageHotelGUI.getNumRoomsToAdd();
                            String roomType = inManageHotelGUI.getRoomTypeToAdd();

                            roomType = roomType.toUpperCase();

                            if(roomsToAdd > 0 && (roomType.equals("STANDARD") || roomType.equals("DELUXE") || roomType.equals("EXECUTIVE"))) {
                                String addRoomsStatus = model.addRoom(hotelIndex, roomsToAdd, roomType);
                                inManageHotelGUI.updateTextArea(addRoomsStatus);
                                inManageHotelGUI.displayRoomList(model.displayRoom(hotelIndex));
                                inManageHotelGUI.handleYesChangeOption();
                                inManageHotelGUI.clearAddRoomFld();
                            } else {
                                inManageHotelGUI.displayRoomList(model.displayRoom(hotelIndex));
                                inManageHotelGUI.setErrorMessage("Invalid inputs! Please double check.");
                            }
                        } else if (confirmation == inManageHotelGUI.getNoOption()) {
                            inManageHotelGUI.handleNoChangeOption();
                        }
                        break;
                    case "REMOVE ROOM:":
                        inManageHotelGUI.clearTextArea();

                        confirmation = inManageHotelGUI.showConfirmationMessage();

                        if(confirmation == inManageHotelGUI.getYesOption()) {
                            int roomToRemove = inManageHotelGUI.getRoomToRemove();

                            if(model.isRoomValid(hotelIndex, roomToRemove)) {
                                String removeRoomStatus = model.removeRoom(hotelIndex, roomToRemove);
                                inManageHotelGUI.updateTextArea(removeRoomStatus);
                                inManageHotelGUI.displayRoomList(model.displayRoom(hotelIndex));
                                inManageHotelGUI.handleYesChangeOption();
                                inManageHotelGUI.clearRemoveRoomFld();
                            } else {
                                inManageHotelGUI.displayRoomList(model.displayRoom(hotelIndex));
                                inManageHotelGUI.setErrorMessage("Invalid inputs! Please double check.");
                            }
                        } else if (confirmation == inManageHotelGUI.getNoOption()) {
                            inManageHotelGUI.handleNoChangeOption();
                        }
                        break;
                    case "UPDATE BASE PRICE:":
                        confirmation = inManageHotelGUI.showConfirmationMessage();

                        if(confirmation == inManageHotelGUI.getYesOption()) {
                            double newBasePrice = inManageHotelGUI.getBasePrice();

                            if(newBasePrice >= 100.0) {
                                String basePriceStatus = model.updateBasePrice(hotelIndex, newBasePrice);
                                inManageHotelGUI.updateTextArea(basePriceStatus);
                                inManageHotelGUI.handleYesChangeOption();
                                inManageHotelGUI.clearUpdBasePriceFld();
                            } else {
                                inManageHotelGUI.setErrorMessage("Invalid inputs! Please double check.");
                            }
                        } else if (confirmation == inManageHotelGUI.getNoOption()) {
                            inManageHotelGUI.handleNoChangeOption();
                        }
                        break;
                    case "DATE PRICE MODIFIER:":
                        confirmation = inManageHotelGUI.showConfirmationMessage();

                        if(confirmation == inManageHotelGUI.getYesOption()) {
                            int dayToModify = inManageHotelGUI.getDayToModify();
                            double newPercent = inManageHotelGUI.getNewPercent();

                            if(model.isDateValid(dayToModify) && newPercent >= 1.0) {
                                String priceModifierStatus = model.modifyDatePrice(hotelIndex, dayToModify, newPercent);
                                inManageHotelGUI.updateTextArea(priceModifierStatus);
                                inManageHotelGUI.displayPriceModList(model.displayDatePrice(hotelIndex));
                                inManageHotelGUI.handleYesChangeOption();
                                inManageHotelGUI.clearDatePriceFld();
                            } else {
                                inManageHotelGUI.setErrorMessage("Invalid inputs! Please double check.");
                            }
                        } else if (confirmation == inManageHotelGUI.getNoOption()) {
                            inManageHotelGUI.handleNoChangeOption();
                        }
                        break;
                    case "REMOVE RESERVATION:":
                        inManageHotelGUI.clearTextArea();

                        confirmation = inManageHotelGUI.showConfirmationMessage();

                        if(confirmation == inManageHotelGUI.getYesOption()) {
                            int roomRes = inManageHotelGUI.getRoomRes();
                            int checkIn = inManageHotelGUI.getCheckInDate();
                            int checkOut = inManageHotelGUI.getCheckOutDate();
                            String name = inManageHotelGUI.getGuestName();

                            if(model.isRoomValid(hotelIndex, roomRes) && model.isDateValid(checkIn) && model.isDateValid(checkOut)) {
                                String removeResStatus = model.removeReservation(hotelIndex, roomRes, name, checkIn, checkOut);
                                inManageHotelGUI.updateTextArea(removeResStatus);
                                inManageHotelGUI.handleYesChangeOption();
                                inManageHotelGUI.clearRemoveResFld();
                            } else {
                                inManageHotelGUI.setErrorMessage("Invalid inputs! Please double check.");
                            }
                        } else if (confirmation == inManageHotelGUI.getNoOption()) {
                            inManageHotelGUI.handleNoChangeOption();
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

