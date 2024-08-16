package Hotel_Reservation_System;

import java.util.ArrayList;
import java.util.List;
/**
 * Main model of the program.
 */
public class HrsModel {
    /**
     * 1 attribute of the class
     */
    private List<Hotel> hotelList;

    /**
     * The sole constructor of the HrsModel Class
     */
    public HrsModel() {
        hotelList = new ArrayList<Hotel>();
    }

    /**
     * hotelExists method checks if the hotel user input exists in the ArrayList of hotels.
     *
     * @param hotelName - a String that holds the user input's hotel name.
     * @return true when the input hotel exists. Otherwise, false.
     */
    public boolean hotelExists(String hotelName) {
        // Iterates through the list of hotels
        for(Hotel hotels : hotelList) {
            // Checks if the hotel name input matches a hotel name in the list of hotels
            if(hotels.getHotelName().equals(hotelName)) {
                return true; // If it does, return true
            }
        }

        return  false; // Otherwise, false
    }

    /**
     * hotelChoice method finds a hotel with the user input's hotel name and returns its index
     *
     * @param hotelName - a String that holds the user input's hotel name.
     * @return hotelIndex that holds the index of the desired hotel.
     */
    public int hotelChoice(String hotelName) {
        int i, hotelIndex = -1;
        boolean found = false;

        // Iterates through the list of existing hotels
        for (i = 0; i < hotelList.size() && !found; i++) {
            // Checks if the input hotel name match a hotel name from the list
            if (hotelName.equals(hotelList.get(i).getHotelName())) {
                found = true; // A match has been found
                hotelIndex = i; // Assigns the index of the match
            }
        }
        return hotelIndex; // Returns the index of the hotel.
    }

    /**
     * createHotel methods adds a new Hotel object to the list of hotels.
     *
     * @param hotelName - a String that holds the user input's hotel name.
     * @param stdRooms - holds the total number of standard room(s) to be created
     * @param dlxRoom - holds the total number of deluxe room(s) to be created
     * @param exeRooms - holds the total number of executive room(s) to be created
     * @return true if the creation of the hotel was successful. Otherwise, false.
     */
    public boolean createHotel(String hotelName, int stdRooms, int dlxRoom, int exeRooms) {
        // Checks if the name has duplicates  or the total room count exceeds 50 or less than or equal to 0.
        if (hotelExists(hotelName) || !(isTotalRoomValid(stdRooms, dlxRoom, exeRooms))) {
            return false; // Returns false, if the hotel was not created.
        }

        // Adds a new Hotel object to the list, if the name is unique and the total room count is from 1 to 50..
        hotelList.add(new Hotel(hotelName, stdRooms, dlxRoom, exeRooms));

        return true; // Returns true if the hotel was successfully created.
    }

    /**
     * isTotalRoomValid method checks if the total number of rooms is at least 1 or at most 50.
     *
     * @param stdRooms - holds the total number of standard room(s) to be created
     * @param dlxRoom - holds the total number of deluxe room(s) to be created
     * @param exeRooms - holds the total number of executive room(s) to be created
     * @return true if it at least 1 or at most 50. Otherwise, false.
     */
    public boolean isTotalRoomValid(int stdRooms, int dlxRoom, int exeRooms) {
        int totalRooms = stdRooms + dlxRoom + exeRooms;

        return totalRooms <= 50 && totalRooms > 0;
    }

    /**
     * isDateValid method checks if the date is within 31 days
     *
     * @param date - an integer value that holds the user date input.
     * @return truw if it is valid. Otherwise, false.
     */
    public boolean isDateValid(int date) {
        return date >= 1 && date <= 31;
    }

    /**
     * viewHighLvl method displays the high-level information of a hotel or an error message.
     *
     * @param highLvlIndex - an integer that holds the index of the hotel the user wants to get the high-level info from.
     * @return a string that holds the high-level information of a hotel, if the hotel exists. Otherwise, an error message.
     */
    public String viewHighLvl(int highLvlIndex) {
        // Checks if the hotel exists
        if (hotelList.get(highLvlIndex) != null) {
            return hotelList.get(highLvlIndex).showHighLevelInfo(); // Returns the high-level information
        }

        return "NO AVAILABLE INFORMATION"; // Returns an error message.
    }

    /**
     * roomAvailability method displays the room availability of a hotel on a selected date.
     *
     * @param hotelRoomAvail  - an integer that holds the index of the hotel the user wants to get the room availability info from.
     * @param selectedDate - an integer that holds the date the user wants to check the room availability on
     * @return a string that holds the room availability information or an error message.
     */
    public String roomAvailability(int hotelRoomAvail, int selectedDate) {
        // Checks if the hotel exists and if the date is valid
        if (hotelList.get(hotelRoomAvail) != null && isDateValid(selectedDate)) {
            return hotelList.get(hotelRoomAvail).showRoomsStatus(selectedDate); // Returns the room availability information
        }

        return "NO AVAILABLE INFORMATION"; // Returns an error message.
    }

    /**
     * roomInfo method displays the room information of a room in a hotel or an error message.
     *
     * @param hotelRoomInfo - an integer that holds the index of the hotel the user wants to get the room info from.
     * @param roomNumber - an integer that holds the room number the user wants to check the information.
     * @return a string that holds the room information or an error message.
     */
    public String roomInfo(int hotelRoomInfo, int roomNumber) {
        // Iterates through the hotel's room list
        for (Room hotelRoom : hotelList.get(hotelRoomInfo).getHotelRooms()) {
            if(hotelRoom.getRoomNumber() == roomNumber) {
                // Gets the string value of the room info from a specific room number
                return hotelRoom.showRoomInfo(roomNumber);
            }
        }

        return "NO AVAILABLE INFORMATION"; // Returns the string
    }

    /**
     * reservationInfo method displays a reservation's info or an error message.
     *
     * @param hotelToViewRes - an integer that holds the index of the hotel the user wants to get a reservation's info from.
     * @param roomNumber - an integer that holds the room number of a reservation.
     * @param guest - a string that holds the guest name of a reservation.
     * @param checkIn - an integer that holds the check-in date of a reservation.
     * @param checkOut - an integer that holds the check-out date of a reservation.
     * @return a string that holds the reservation info or an error message.
     */
    public String reservationInfo(int hotelToViewRes, int roomNumber, String guest, int checkIn, int checkOut) {
        String reservationInfo = "";

        // Checks if the hotel exists
        if (hotelList.get(hotelToViewRes) != null) {
            // Iterates through the hotel's rooms
            for (Room hotelRoom : hotelList.get(hotelToViewRes).getHotelRooms()) {
                // Checks if the room number matches and if the dates are valid.
                if (hotelRoom.getRoomNumber() == roomNumber && isDateValid(checkIn) && isDateValid(checkOut)) {
                    reservationInfo = hotelRoom.showReservationStatus(guest, checkIn, checkOut);
                }
            }
        }

        return reservationInfo;
    }

    /**
     * previewReservation method displays a preview of the reservation being made.
     *
     * @param name - a String that holds tha guest's name
     * @param room - an integer value that holds the room number to be reserved
     * @param checkIn - an integer value that holds the check-in date for the reservation
     * @param checkOut - an integer value that holds the check-out date for the reservation
     * @param price - a double value that holds the reservation's price with no discount applied yet
     * @param roomType - a String value that holds the desired room type
     * @return the reservation info
     */
    public String previewReservation(String name, int room, int checkIn, int checkOut, double price, String roomType) {
        double total;
        StringBuilder reservationInfo = new StringBuilder();

        reservationInfo.append("\n");
        reservationInfo.append("\t[NO DISCOUNTS APPLIED YET]\n");
        reservationInfo.append("\tGuest Name  : ").append(name).append("\n");
        reservationInfo.append("\tRoom Number : ").append(room).append("\n");
        reservationInfo.append("\tCheck-in    : December ").append(checkIn).append(", 2024").append("\n");
        reservationInfo.append("\tCheck-out   : December ").append(checkOut).append(", 2024").append("\n");
        reservationInfo.append(String.format("\tTotal Days  : %d\n", checkOut - checkIn));

        switch(roomType) {
            case "STANDARD":
                price += 0;
                break;
            case "EXECUTIVE":
                price *= 1.35;
                break;
            case "DELUXE":
                price *= 1.20;
                break;
        }

        total = price * (checkOut - checkIn); // Computes for the total price

        reservationInfo.append(String.format("\tTotal Price : %.2f", total));

        return reservationInfo.toString();
    }

    /**
     * getHotelBasePrice returns the base price of the hotel
     *
     * @param hotelIndex - an integer that holds the hotel's index
     * @return the base price of the hotel
     */
    public double getHotelBasePrice(int hotelIndex) {
        return hotelList.get(hotelIndex).getBasePricePerNight();
    }

    /**
     * changeHotelName method sets a new hotel name for the hotel being managed.
     *
     * @param hotelIndex - an integer that holds the index of the hotel the user wants to change the hotel name.
     * @param newHotelName - a string that holds the new hotel name from the input of the user.
     * @return a string that holds a message whether the change was successful or not.
     */
    public String changeHotelName(int hotelIndex, String newHotelName) {
        String oldName;

        // Stores the hotel's old name
        oldName = hotelList.get(hotelIndex).getHotelName();

        // Checks if the new name is still unique among the hotel list.
        if (!hotelExists(newHotelName)) {
            // If it is unique, then the input will be set as the new name of the hotel
            hotelList.get(hotelIndex).setHotelName(newHotelName);

            // Shows the change that happened
            return "Old Hotel Name: " + oldName + "\n" +
                    "New Hotel Name: " + newHotelName + "\n\n" +
                    "!!! SUCCESSFULLY CHANGED THE HOTEL NAME !!!";
        }

        // Returns an error message if the new name already exists
        return "!!! HOTEL NAME ALREADY EXISTS !!!";
    }

    /**
     * updateBasePrice method updates the base price of a hotel, which is at first, 1299.0.
     *
     * @param hotelIndex - an integer that holds the index of the hotel the user wants to change the base price.
     * @param basePrice - a double that holds the new base price of the hotel, which must be more than 100.
     * @return a string that holds a message whether the change was successful or not.
     */
    public String updateBasePrice(int hotelIndex, double basePrice) {
        // Checks if the input is at least 100
        if (basePrice >= 100) {
            // If it is, then set the input as the new base price
            hotelList.get(hotelIndex).setBasePricePerNight(basePrice);

            // Shows the change that happened, including the prices per room type
            return "Original Base Price Per Night: 1299" + "\n" +
                    "Updated Base Price Per Night: " + basePrice + "\n\n" +
                    "Standard Room Base Price: " + hotelList.get(hotelIndex).getBasePricePerNight() + "\n" +
                    "Deluxe Room Base Price: " + (hotelList.get(hotelIndex).getBasePricePerNight() * 1.20) + "\n" +
                    "Executive Room Base Price: " + (hotelList.get(hotelIndex).getBasePricePerNight() * 1.35) + "\n\n" +
                    "!!! SUCCESSFULLY UPDATED BASE PRICE !!!";
        }

        // Returns an error message if the new price is below 100
        return "!!! NEW PRICE SHOULD ATLEAST BE 100 !!!";
    }

    /**
     * isRoomValid method checks if the room exists within the room list of a hotel.
     *
     * @param hotelIndex - an integer that holds the index of the hotel the user wants to check the room for.
     * @param roomNum - an integer that holds the room number.
     * @return true if the room still exists. Otherwise, false.
     */
    public boolean isRoomValid(int hotelIndex, int roomNum) {
        // Iterates through each room in a hotel
        for (int i = 0; i < hotelList.get(hotelIndex).getHotelRooms().size(); i++) {
            // Checks if the room number input matches a room number in the room list
            if (hotelList.get(hotelIndex).getHotelRooms().get(i).getRoomNumber() == roomNum) {
                return true;
            }
        }
        return false;
    }

    /**
     * addRoom method adds a specific number of rooms of a specific room type.
     *
     * @param hotelToAdd - an integer that holds the index of the hotel where the user wants to add rooms.
     * @param numRoomsToAdd - an integer that holds the number of rooms to be added in a hotel.
     * @param roomType - a string that holds the room type.
     * @return a string that holds a message whether the change was successful or not.
     */
    public String addRoom(int hotelToAdd, int numRoomsToAdd, String roomType) {
        int oldNumOfRooms = hotelList.get(hotelToAdd).getHotelRooms().size();
        int stdRooms = 0, dlxRooms = 0, exeRooms = 0;

        roomType = roomType.toUpperCase(); // Converts the string input to all caps

        // Checks if the number of rooms to be added is zero, positive, or negative
        if (numRoomsToAdd < 0) {
            return "!!! INPUT MUST BE POSITIVE OR ZERO !!!";
        } else {
            // If it is zero or positive, then the number of rooms will be successfully added
            if (hotelList.get(hotelToAdd).addRoom(numRoomsToAdd, roomType)) {
                for (Room rooms : hotelList.get(hotelToAdd).getHotelRooms()) {
                    if (rooms instanceof StandardRoom) {
                        stdRooms++;
                    } else if (rooms instanceof DeluxeRoom) {
                        dlxRooms++;
                    } else if (rooms instanceof ExecutiveRoom) {
                        exeRooms++;
                    }
                }

                // Shows the change that happened
                return "Old number of rooms: " + oldNumOfRooms + "\n" +
                        "Updated number of rooms: " + hotelList.get(hotelToAdd).getHotelRooms().size() + "\n\n" +
                        "STANDARD ROOMS: " + stdRooms + "\n" +
                        "DELUXE ROOMS: " + dlxRooms + "\n" +
                        "EXECUTIVE ROOMS: " + exeRooms + "\n\n" +
                        "!!! SUCCESSFULLY ADDED ROOM(s) !!!\n\n";
            }
        }

        // Returns an error message if the number of rooms to be added reaches or exceeds 50
        return "!!! REACHED MAX NUMBER OF ROOMS !!!";
    }

    /**
     * removeRoom method removes a room from the hotel.
     *
     * @param hotelToRemove - an integer that holds the index of the hotel where the user wants to remove a room.
     * @param roomNumToRemove - an integer that holds the room number of the room to be removed.
     * @return a string that holds a message whether the change was successful or not.
     */
    public String removeRoom(int hotelToRemove, int roomNumToRemove) {
        // Stores the old number of rooms in a hotel
        int oldNumOfRooms = hotelList.get(hotelToRemove).getHotelRooms().size();
        int stdRooms = 0, dlxRooms = 0, exeRooms = 0;

        if(hotelList.get(hotelToRemove).getHotelRooms().size() == 1) {
            return "!!! THERE MUST BE A ROOM THAT REMAINS !!!";
        }

        // Checks if the room number exists
        if (isRoomValid(hotelToRemove, roomNumToRemove)) {
            // Iterates through the hotel's rooms
            for (Room hotelRooms : hotelList.get(hotelToRemove).getHotelRooms()) {
                // Checks if the room number match a room
                if (hotelRooms.getRoomNumber() == roomNumToRemove) {
                    // Checks if the room is booked or not
                    if (hotelRooms.isBooked() && hotelList.get(hotelToRemove).removeRoom(roomNumToRemove)) {
                        for (Room rooms : hotelList.get(hotelToRemove).getHotelRooms()) {
                            if (rooms instanceof StandardRoom) {
                                stdRooms++;
                            } else if (rooms instanceof DeluxeRoom) {
                                dlxRooms++;
                            } else if (rooms instanceof ExecutiveRoom) {
                                exeRooms++;
                            }
                        }

                        // Shows the change that happened
                        return "Old number of rooms: " + oldNumOfRooms + "\n" +
                                "Updated number of rooms: " + hotelList.get(hotelToRemove).getHotelRooms().size() + "\n\n" +
                                "STANDARD ROOMS: " + stdRooms + "\n" +
                                "DELUXE ROOMS: " + dlxRooms + "\n" +
                                "EXECUTIVE ROOMS: " + exeRooms + "\n\n" +
                                "!!! SUCCESSFULLY REMOVED A ROOM !!!\n\n";
                    }
                }
            }
        } else {
            // Displays an error message if the room is nonexistent
            return "!!! ROOM IS NOT VALID !!!";
        }

        // Displays an error message if the room is booked
        return "!!! ROOM IS BOOKED !!!";
    }

    /**
     * removeReservation method removes a reservation for a room in a hotel.
     *
     * @param hotelToRemoveReservation - an integer that holds the index of the hotel where the user wants to remove a reservation.
     * @param roomNum - an integer that holds the room number of a reservation.
     * @param guestName - a string that holds the guest name of a reservation.
     * @param checkIn - an integer that holds the check-in date of a reservation.
     * @param checkOut - an integer that holds the check-out date of a reservation.
     * @return  a string that holds a message whether the change was successful or not.
     */
    public String removeReservation(int hotelToRemoveReservation, int roomNum, String guestName, int checkIn, int checkOut) {
        // Checks if the room is valid and if the check-in and check-out dates are valid
        if (isRoomValid(hotelToRemoveReservation, roomNum) && isDateValid(checkIn) && isDateValid(checkOut)) {
            // Iterates through the hotel's rooms
            for (Room rooms : hotelList.get(hotelToRemoveReservation).getHotelRooms()) {
                // Checks if the reservation was successfully removed
                if (rooms.removeReservation(guestName, checkIn, checkOut)) {
                    // Shows the change that happened
                    return "\n!!! SUCCESSFULLY REMOVED A RESERVATION !!!";
                }
            }
        } else {
            // Displays an error message if the room or date is not valid
            return "!!! ROOM OR DATE IS NOT VALID !!!";
        }

        // Displays an error message if the reservation is nonexistent
        return "!!! RESERVATION DOES NOT EXIST !!!";
    }

    /**
     * removeHotel method removes the current hotel being managed from the hotel list, including its rooms and reservations.
     *
     * @param hotelToRemove - an integer that holds the index of the hotel that the user wants to remove.
     * @return a string that holds a message whether the change was successful or not.
     */
    public String removeHotel(int hotelToRemove) {
        // Stores the name of the hotel that is being removed
        String removedHotelName = hotelList.get(hotelToRemove).getHotelName();

        // Checks if the hotel exists
        if (hotelList.get(hotelToRemove) != null) {
            // If it exists, the hotel is removed
            hotelList.remove(hotelToRemove);

        }

        // Shows the change that happened
        return "\t!!! SUCCESSFULLY REMOVED HOTEL [" + removedHotelName + "] !!!";
    }

    /**
     * modifyDatePrice method modifies the multiplier for the price for each day, which is initialized to be 100% or 1
     *
     * @param hotelToModify - an integer that holds the index of the hotel that the user wants to modify the date price.
     * @param dayToModify - an integer that holds the day the user wants to modify.
     * @param newPricePercent - a double value that holds the new price percent modifier from the user inout.
     * @return a string that holds a message whether the change was successful or not.
     */
    public String modifyDatePrice(int hotelToModify, int dayToModify, double newPricePercent) {
        // Checks id the date is valid
        if (isDateValid(dayToModify)) {
            // Checks if the price percent modifier is positive
            if (newPricePercent >= 0.0) {
                // Set the new price modifier for the desired day
                hotelList.get(hotelToModify).setDatePriceModifier(dayToModify, newPricePercent);

                // Shows the change that happened
                return "\n!!! SUCCESSFULLY APPLIED THE DATE PRICE MODIFIER FOR DECEMBER " + dayToModify + " !!!";
            } else {

                // Returns an error message if the price modifier is negative
                return "!!! INVALID INPUT FOR DATE PRICE MODIFIER !!!";
            }
        } else {
            // Returns an error message if the date is invalid
            return "!!! DAY DOES NOT EXIST !!!";
        }
    }

    /**
     * displayHotelList displays the existing hotels in the hotelList.
     *
     * @return a string that holds the list of hotels.
     */
    public String displayHotelList() {
        StringBuilder hotelNames = new StringBuilder();

        for(Hotel hotel : hotelList) {
            hotelNames.append(hotel.getHotelName()).append("\n");
        }

        return hotelNames.toString();
    }

    /**
     * doesRoomNumTypeMatch checks if a given room number matches with the room type in the hotel to be checked
     *
     * @param hotelIndex - an integer value holds the index of the hotel
     * @param roomNum - an integer value that holds the index of room of the hotel
     * @param roomType - a String that holds the room type
     * @return true if in the hotel to be checked, the room number matches with room type, otherwise false
     */
    public boolean doesRoomNumTypeMatch(int hotelIndex, int roomNum, String roomType) {
        roomType = roomType.toUpperCase();

        //
        for (Room hotelRooms : hotelList.get(hotelIndex).getHotelRooms()) {
            if (hotelRooms.getRoomType().equals(roomType)) {
                if (hotelRooms.getRoomNumber() == roomNum) {
                    return true; // room number matches with room type
                }
            }
        }
        return false; // room number does not match with room type
    }

    /**
     * displayRooms method displays the rooms of a hotel, which is categorized by their room types.
     *
     * @param hotelToDisplayRooms - an integer that holds the index of the hotel that the user wants to display the rooms.
     *
     * @return a string that holds the list of rooms.
     */
    public String displayRoom(int hotelToDisplayRooms) {
        return hotelList.get(hotelToDisplayRooms).displayRooms();
    }

    /**
     * bookingSimulation method simulates the process of making a reservation with or without discounts.
     *
     * @param guestName - a string that holds the guest name of a reservation.
     * @param roomType - a string that holds the room type the user desires to book.
     * @param roomNum - an integer that holds the room number of a reservation.
     * @param checkIn - an integer that holds the check-in date of a reservation.
     * @param checkOut - an integer that holds the check-out date of a reservation.
     * @param discountCode - a string that holds the code to get a specific discount.
     * @return a string that holds a message whether the change was successful or not.
     */
    public String bookingSimulation(int hotelToBook, String guestName, String roomType, int roomNum, int checkIn, int checkOut, String discountCode) {
        roomType = roomType.toUpperCase();
        boolean found = false;
        Room roomReserve = null;

        // Checks if the check-in date is not on the 31st day and if the check-out date is not on the 1st day
        if (checkIn != 31 && checkOut != 1) {
            if(hotelList.get(hotelToBook).isRoomAvailable(roomNum, checkIn, checkOut)) {
                // Iterates through the rooms inside a hotel
                for(Room roomsToReserve : hotelList.get(hotelToBook).getHotelRooms()) {
                    if (roomsToReserve.getRoomNumber() == roomNum) {
                        roomReserve = roomsToReserve;
                        found = true;
                        break;
                    }
                }

                if(found) {
                    // Checks if the room is the same type as what the user puts in the room type
                    if(doesRoomNumTypeMatch(hotelToBook, roomNum, roomType)) {
                        // Make the reservation
                        roomReserve.makeReservation(guestName, checkIn, checkOut, discountCode);

                        // Shows the reservation that happened
                        return roomReserve.showReservationStatus(guestName, checkIn, checkOut);
                    } else {
                        // Returns an error message if the room number and room type does not match
                        return "!!! ROOM TYPE AND ROOM NUMBER DOES NOT MATCH !!!";
                    }
                } else {
                    // Returns an error message if the room does not exist
                    return "!!! ROOM DOES NOT EXIST !!!";
                }
            } else {
                // Returns an error message if the room does not exist
                return "!!! ROOM DOES NOT EXIST !!!";
            }
        }
        // Returns an error message if either the check-in or check-out dates are invalid
        return "!!! CHECK IN OR CHECK OUT DATES ARE INVALID. !!!";
    }

    /**
     * isHotelListEmpty method checks if there are hotels existing already.
     *
     * @return true, if the list is empty. Otherwise, false.
     */
    public boolean isHotelListEmpty() {
        // Returns true if hotel list is empty
        return hotelList.isEmpty();
    }

    /**
     * displayDatePrice method returns the list of date price modifier percents in string format
     *
     * @return list
     */
    public String displayDatePrice(int hotelIndex) {
        return hotelList.get(hotelIndex).displayDatePriceMod();
    }
}

