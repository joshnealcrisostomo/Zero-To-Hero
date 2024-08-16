package Hotel_Reservation_System;

import java.util.ArrayList;
import java.util.List;

/**
 * Hotel class that holds a list of Room class
 */
public class Hotel {
    /**
     * 4 attributes of the class
     */
    private String hotelName;
    private double basePricePerNight;
    private List<Room> hotelRooms; // Declares a List of rooms in a hotel
    private double[] datePriceModifier = new double[31];// 30 or 31

    /**
     * The sole constructor of a Hotel class.
     *
     * @param hotelName      - a String input that sets the hotel name in the creation of a hotel
     * @param standardCount  - an integer value input that sets the number of standard rooms in the creation of a hotel
     * @param deluxeCount    - an integer value input that sets the number of deluxe rooms in the creation of a hotel
     * @param executiveCount - an integer value input that sets the number of executive rooms in the creation of a hotel
     */
    public Hotel(String hotelName, int standardCount, int deluxeCount, int executiveCount) {
        // Assigns the parameters to this class' attributes using the "this" keyword
        this.hotelName = hotelName;
        this.hotelRooms = new ArrayList<>(); // Initializes a new Array List for the hotel rooms
        this.basePricePerNight = 1299.0;
        initializeHotelRooms(standardCount, deluxeCount, executiveCount); // Initializes the hotel rooms
        initializeDatePriceModifier();
    }

    /**
     * initializeHotelRooms method that initializes the rooms in a hotel with their room type and room numbers and base price
     *
     * @param sCount - holds the total number of standard room(s) to be created
     * @param dCount - holds the total number of deluxe room(s) to be created
     * @param eCount - holds the total number of executive room(s) to be created
     */
    private void initializeHotelRooms(int sCount, int dCount, int eCount) {
        int i;
        Room standardRoom, deluxeRoom, executiveRoom;

        for (i = 1; i <= sCount; i++) {
            standardRoom = new StandardRoom(i, basePricePerNight);
            standardRoom.setHotelStayed(this);
            hotelRooms.add(standardRoom);
        }

        for (i = sCount + 1; i <= (sCount + dCount); i++) {
            deluxeRoom = new DeluxeRoom(i, basePricePerNight);
            deluxeRoom.setHotelStayed(this);
            hotelRooms.add(deluxeRoom);
        }

        for (i = sCount + dCount + 1; i <= (sCount + dCount + eCount); i++) {
            executiveRoom = new ExecutiveRoom(i, basePricePerNight);
            executiveRoom.setHotelStayed(this);
            hotelRooms.add(executiveRoom);
        }
    }

    /**
     * computeEstimateEarnings method computes for the estimated monthly earnings
     *
     * @return totalEarnings - total earnings for the whole month
     */
    public double computeEstimateEarnings() {
        double totalEarnings = 0.0;

        // Iterates through each hotel room
        for (Room room : hotelRooms) {
            // Iterates through each reservation made for the current room
            for (Reservation reservation : room.getReservation()) {
                // Adds all the total prices together
                totalEarnings += reservation.getTotalPrice();
            }
        }

        return totalEarnings;
    }

    /**
     * showHighLevelInfo method shows a hotel's name, room count, and estimated monthly earnings
     *
     * @return string of Strings that holds their corresponding values
     */
    public String showHighLevelInfo() {
        return "\tHotel Name: " + getHotelName() + "\n"
                + "\tRoom Count: " + getHotelRooms().size() + "\n"
                + "\tEstimated Earnings (monthly): " + computeEstimateEarnings() + "\n";
    }

    /**
     * addRoom method adds a specific number of rooms until it reaches the limit
     *
     * @param numRoomToAdd - integer value that holds the desired number of rooms the user wants to add
     * @return true or false depending on the conditions
     */
    public boolean addRoom(int numRoomToAdd, String roomType) {
        int i;
        int maxRoomNum = 0;
        Room stdRoom, dlxRoom, exeRoom;

        // Checks if the current number of rooms plus the added number of rooms exceed 50 total rooms
        if (numRoomToAdd + hotelRooms.size() <= 50 && !(numRoomToAdd < 0)) {
            for (Room room : hotelRooms) {
                if (room.getRoomNumber() > maxRoomNum) {
                    maxRoomNum = room.getRoomNumber();
                }
            }

            // Increment the maxRoomNum by 1
            maxRoomNum += 1;

            // Creates new Room objects for numRoomToAdd-times
            for (i = 0; i < numRoomToAdd; i++) {
                switch (roomType) {
                    case "STANDARD":
                        stdRoom = new StandardRoom(maxRoomNum++, getBasePricePerNight());
                        stdRoom.setHotelStayed(this);
                        hotelRooms.add(stdRoom);
                        break;
                    case "DELUXE":
                        dlxRoom = new DeluxeRoom(maxRoomNum++, getBasePricePerNight());
                        dlxRoom.setHotelStayed(this);
                        hotelRooms.add(dlxRoom);
                        break;
                    case "EXECUTIVE":
                        exeRoom = new ExecutiveRoom(maxRoomNum++, getBasePricePerNight());
                        exeRoom.setHotelStayed(this);
                        hotelRooms.add(exeRoom);
                        break;
                }
            }
            return true;
        }
        return false; // Returns false, if the rooms were not added
    }

    /**
     * removeRoom method that removes a room from a hotel
     *
     * @param roomNumber - integer value that holds the room number that the user wants to remove
     * @return true or false depending on the conditions
     */
    public boolean removeRoom(int roomNumber) {
        Room roomToRemove = null;
        // Iterates through each hotel room to find the room that matches roomNumber
        for (Room room : hotelRooms) {
            // Checks if the hotel has at least one room
            if (!(hotelRooms.size() <= 1)) {
                // Checks if the room's number matches roomNumber and if the book is reserved
                if (roomNumber == room.getRoomNumber() && room.isBooked()) {
                    roomToRemove = room;
                    break;
                }
            }
        }

        // Checks if the room exists or not
        if (roomToRemove != null) {
            hotelRooms.remove(roomToRemove);
            return true; // Returns true, if the room was successfully removed
        }

        return false; // Returns true, if the room was not successfully removed
    }

    /**
     * showRoomStatus method that displays the number of available and unavailable rooms during a specific date
     *
     * @param selectedDate - - integer value that holds the date input from the user
     * @return string of Strings that holds their corresponding information
     */
    public String showRoomsStatus(int selectedDate) {
        int availableRooms = 0;
        int bookedRooms = 0;
        boolean isBooked;

        // Iterates through each hotel room
        for (Room rooms : hotelRooms) {
            // Initializes local attribute isBooked to false
            isBooked = false;

            // Iterates through each reservation for the room
            for (Reservation reservation : rooms.getReservation()) {
                // Checks if the selected date is within a reservation
                if (reservation.isDateWithinReservation(selectedDate)) {
                    bookedRooms++; // If it is, increment the number of booked rooms
                    isBooked = true; // Assign isBooked with true
                    break; // Exit the inner loop
                }
            }

            // If the room is not booked, increment the number of available rooms
            if (!isBooked) {
                availableRooms++;
            }
        }

        return "\tAvailable Rooms on December " + selectedDate + ": " + availableRooms + "\n"
                + "\tBooked Rooms on December " + selectedDate + ": " + bookedRooms;
    }

    /**
     * isRoomAvailable method that accepts room number, check in date and checkout date and compares it to the existing records
     *
     * @param room     - integer value that holds the room number that the user wants to remove
     * @param checkIn  - integer value that holds the check-in date of the guest
     * @param checkOut - integer value that holds the check-out date of the guest
     * @return true if condition is satisfied otherwise returns false
     */
    public boolean isRoomAvailable(int room, int checkIn, int checkOut) {
        Room roomToCheck = null;

        for(Room rooms : hotelRooms) {
            if(rooms.getRoomNumber() == room) {
                roomToCheck = rooms;
                break;
            }
        }

        if(roomToCheck == null) {
            return false;
        }

        // Iterate through each reservation in the desired room
        for (Reservation reservation : roomToCheck.getReservation()) {
            // Checks if the input check-in date is before the reservation check-out date and on or after the reservation check-in date
            // Checks if the input check-out date is after the reservation check-in date and on or before the reservation check-out date
            if ((checkIn < reservation.getCheckOutDate() && checkIn >= reservation.getCheckInDate()) || (checkOut > reservation.getCheckInDate() && checkOut <= reservation.getCheckOutDate())) {
                return false; // Returns false, if it is
            }
        }

        return true; // Returns true, if it is not
    }

    /**
     * isRoomAvailable method that accepts room number
     *
     * @param room - integer value that holds the room number that the user wants to remove
     * @return true if condition is satisfied otherwise returns false
     */
    public boolean isRoomAvailable(int room) {
        // Iterates through the rooms of the current hotel
        for (Room hotelRoom : this.getHotelRooms()) {
            // Checks if the room number match the current room's number
            if (hotelRoom.getRoomNumber() == room) {
                return true;
            }
        }

        return false;
    }

    /**
     * getHotelName method that returns the name of the hotel
     *
     * @return hotelName - a String that corresponds to the name of the hotel
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * getHotelRooms method that returns a list of hotel rooms
     *
     * @return hotelRooms - List of hotel rooms the user created
     */
    public List<Room> getHotelRooms() {
        return hotelRooms;
    }

    /**
     * getBasePricePerNight method that returns the price of the room per night
     *
     * @return basePricePerNight - an integer value that corresponds to the price of the room per night
     */
    public double getBasePricePerNight() {
        return basePricePerNight;
    }

    /**
     * setHotelName method that accepts a String and assign it to the own class
     *
     * @param hotelName - A string input that corresponds to the hotel name
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * setBasePricePerNight method that accepts a double and assign it to the class on basePricePerNight attribute
     *
     * @param basePricePerNight - A double value input that corresponds to the price of the room per night
     */
    public void setBasePricePerNight(double basePricePerNight) {
        this.basePricePerNight = basePricePerNight;

        for (Room room : hotelRooms) {
            room.setRoomPricePerNight(basePricePerNight);
        }
    }

    /**
     * displayRooms method displays the list of rooms in a hotel with their respective types.
     *
     * @return a formatted string that holds the room list.
     */
    public String displayRooms() {
        int i, j, std = 0, dlx = 0, exe = 0;
        int[] standardIndex = new int[getHotelRooms().size()];
        int[] deluxeIndex = new int[getHotelRooms().size()];
        int[] executiveIndex = new int[getHotelRooms().size()];

        StringBuilder result = new StringBuilder();

        for (i = 0; i < getHotelRooms().size(); i++) {
            if (getHotelRooms().get(i).getRoomType().equals("STANDARD")) {
                standardIndex[std++] = i;
            } else if (getHotelRooms().get(i).getRoomType().equals("DELUXE")) {
                deluxeIndex[dlx++] = i;
            } else if (getHotelRooms().get(i).getRoomType().equals("EXECUTIVE")) {
                executiveIndex[exe++] = i;
            }
        }

        result.append("\tSTANDARD ROOMS:\n");
        for (j = 0; j < std; j++) {
            result.append("\t").append(getHotelRooms().get(standardIndex[j]).getRoomNumber()).append("\n");
        }

        result.append("\n");

        result.append("\tDELUXE ROOMS:\n");
        for (j = 0; j < dlx; j++) {
            result.append("\t").append(getHotelRooms().get(deluxeIndex[j]).getRoomNumber()).append("\n");
        }

        result.append("\n");

        result.append("\tEXECUTIVE ROOMS:\n");
        for (j = 0; j < exe; j++) {
            result.append("\t").append(getHotelRooms().get(executiveIndex[j]).getRoomNumber()).append("\n");
        }

        return result.toString();
    }

    /**
     * initializeDatePriceModifier method initializes the date price modifiers for each day with 1.00
     */
    private void initializeDatePriceModifier() {
        int i;

        for (i = 1; i <= 31; i++) {
            this.datePriceModifier[i - 1] = 1.0;
        }
    }

    /**
     * getDatePRiceModifier method returns the array of datePriceModifiers
     *
     * @return array of datePriceModifiers
     */
    public double[] getDatePriceModifier() {
        return this.datePriceModifier;
    }

    /**
     * setDatePriceModifier method lets the user modify the percentage multiplier for each day.
     *
     * @param day - an integer that holds the value of a day in a 31-day month.
     * @param newPricePercent - a double value that holds the modified percent the user wants to set.
     */
    public void setDatePriceModifier(int day, double newPricePercent) {
        this.datePriceModifier[day - 1] = newPricePercent;
    }

    /**
     * displayDatePriceMod method returns a string of the date price modifier percent list for each day
     *
     * @return string
     */
    public String displayDatePriceMod() {
        int i;
        StringBuilder result = new StringBuilder();

        for(i = 1; i <= 31; i++) {
            result.append("\t").append("December ").append(i).append(": ").append(datePriceModifier[i-1]).append("\n");
        }

        return result.toString();
    }
}

