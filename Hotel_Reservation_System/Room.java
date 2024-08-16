package Hotel_Reservation_System;

import java.util.ArrayList;
import java.util.List;

/**
 * Room class that holds a list of reservations
 */
public abstract class Room implements Reservable {
    /**
     * 5 attributes of the class
     */
    private int roomNumber;
    private double roomPricePerNight;
    private List<Reservation> roomReservation;
    private String roomType;
    private Hotel hotelStayed;

    /**
     * The sole constructor of a Room class.
     *
     * @param roomNumber - an integer value that holds the room number to be assigned
     * @param roomPricePerNight - a double value that holds the base price per night to be assigned
     * @param roomType - a String that holds the room type of the room
     */
    public Room(int roomNumber, double roomPricePerNight, String roomType) {
        this.roomNumber = roomNumber;
        this.roomPricePerNight = roomPricePerNight;
        this.roomReservation = new ArrayList<>();
        this.roomType = roomType;
    }

    /**
     * isBooked method that checks if a room is booked and returns a boolean
     *
     * @return true if room is booked, otherwise false
     */
    @Override
    public boolean isBooked() {
        return roomReservation.isEmpty();
    }

    /**
     * makeReservation method that makes a reservation by adding a new instance in the list of reservations.
     *
     * @param guestName a String that holds the name of the guest name to be assigned in the reservation
     * @param checkInDate an integer value that holds the check-in date to be assigned in the reservation
     * @param checkOutDate an integer value that holds the check-out date to be assigned in the reservation
     * @param discountCode a String that holds the discount code if there is any
     */
    @Override
    public void makeReservation(String guestName, int checkInDate, int checkOutDate, String discountCode) {
        // Adds a new instance of a reservation to the specified room
        this.roomReservation.add(new Reservation(guestName, this, checkInDate, checkOutDate, discountCode));
    }

    /**
     * removeReservation method removes an existing reservation from a room.
     *
     * @param guestName a String that holds the name of the guest name to be removed in the reservation
     * @param checkIn an integer value that holds the check-in date to be removed in the reservation
     * @param checkOut an integer value that holds the check-out date to be removed in the reservation
     *
     * @return true if the reservation is successfully removed, otherwise false
     */
    @Override
    public boolean removeReservation(String guestName, int checkIn, int checkOut) {
        // Iterates through the list of reservations inside a room
        for (Reservation reservation : roomReservation) {
            // Checks if the inputs match the reservation's information
            if (reservation.infoMatches(guestName, this.getRoomNumber(), checkIn, checkOut)) {
                roomReservation.remove(reservation);
                return true;
            }
        }
        return false;
    }

    /**
     * showReservationStatus
     *
     * @param guestName a String that holds the name of the guest to be checked in the records
     * @param checkIn an integer value that holds the check-in date to be checked in the records
     * @param checkOut an integer value that holds the check-out date to be checked in the records
     * @return a String that displays the reservation information or if there is no reservation found
     */
    @Override
    public String showReservationStatus(String guestName, int checkIn, int checkOut) {
        // Iterates through the list of reservations inside a room
        for (Reservation reservation : roomReservation) {
            // Checks if the inputs match the reservation's information
            if (reservation.infoMatches(guestName, this.getRoomNumber(), checkIn, checkOut)) {

                // Displays the reservation's information
                return reservation.showReservationInfo();
            }
        }

        // If not, it will display an error message
        return "!!! NO RESERVATION FOUND !!!";
    }

    /**
     * getReservation method that returns the list of reservations
     *
     * @return roomReservation, the list of reservations
     */
    @Override
    public List<Reservation> getReservation() {
        return roomReservation;
    }

    /**
     * getRoomNumber method that returns the room number of the room
     *
     * @return an integer value that holds the room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * getRoomPricePerNight method that returns the price of the room per night
     *
     * @return a double value that holds the price of the room per night
     */
    public double getRoomPricePerNight() {
        return roomPricePerNight;
    }

    /**
     * getRoomPriceForDay is an abstract method that returns the price per day from the date price modifier
     *
     * @param day - an integer value that holds the day from 1 to 31
     * @return the room's price per day which is modified in the date price modifier
     */
    public abstract double getRoomPriceForDay(int day);

    /**
     * setRoomPricePerNight method sets the price of a room per night
     *
     * @param roomPricePerNight - a double value that holds a room's price per night.
     */
    public void setRoomPricePerNight(double roomPricePerNight) {
        this.roomPricePerNight = roomPricePerNight;
    }

    /**
     * getRoomType is an abstract method that returns the room's type
     *
     * @return a room's type
     */
    public abstract String getRoomType();

    /**
     * showRoomInfo returns a string that displays a room's information
     *
     * @param selectedRoom - an integer value that holds the user's desired room to view
     * @return a string that contains the room's information
     */
    public String showRoomInfo(int selectedRoom) {
        int j;
        int day;
        String roomStatus;
        StringBuilder roomInfo = new StringBuilder();

        // Checks if the room number input matches the room's room number
        if (this.getRoomNumber() == selectedRoom) {
            roomInfo.append("\tRoom Number: ").append(selectedRoom).append("\n")
                    .append("\tPrice per night: ").append(this.getRoomPricePerNight()).append("\n")
                    .append("\tRoom Type: ").append(this.roomType).append("\n")
                    .append("\n\t     [Availability - December 2024] \n")
                    .append("\n\t[X] - BOOKED        [ ] - AVAILABLE\n\n");

            // Splits the format into two halves
            String[] firstHalf = new String[16];
            String[] secondHalf = new String[15];

            // Iterates through the days
            for (day = 1; day <= 31; day++) {
                // Initializes each day with a space
                roomStatus = " ";

                // If a reservation exists on that day, mark the day with an "X"
                for (Reservation reservation : roomReservation) { // changed this.getReservation() to roomReservation
                    if (reservation.isDateWithinReservation(day)) {
                        roomStatus = "X";
                        break;
                    }
                }

                // Prints the formatted days
                if (day <= 16) {
                    firstHalf[day - 1] = String.format("December %02d: %-5s", day, roomStatus);
                } else {
                    secondHalf[day - 17] = String.format("December %02d: %-5s", day, roomStatus);
                }
            }

            for (j = 0; j < 16; j++) {
                if (j < 15) {
                    roomInfo.append(String.format("\t%-20s\t%s%n", firstHalf[j], secondHalf[j]));
                } else {
                    roomInfo.append(String.format("\t%-20s%n", firstHalf[j]));
                }
            }
            roomInfo.append("\n");
        }
        return roomInfo.toString();
    }

    /**
     * setHotelStayed method sets the hotel where the reservation was made
     *
     * @param hotel - a value with Hotel data type that holds the current hotel.
     */
    public void setHotelStayed(Hotel hotel) {
        this.hotelStayed = hotel;
    }

    /**
     * getHotelStayed method returns the current hotel stayed at
     *
     * @return hotelStayed
     */
    public Hotel getHotelStayed() {
        return hotelStayed;
    }

}

