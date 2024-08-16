package Hotel_Reservation_System;

/**
 * Reservation class that holds the attributes of a hotel reservation
 */
public class Reservation {
    /**
     * 6 attributes of the class
     */
    private String guestName, discountCode;
    private int checkInDate, checkOutDate;
    private double totalPrice;
    private Room roomReservation;

    /**
     * The only Constructor of the Reservation class
     *
     * @param guestName - String value indicating the guest's name
     * @param roomReservation - attribute with Room data type that holds the room's information and reservation
     * @param checkInDate - integer value that holds the check-in date of the guest
     * @param checkOutDate - integer value that holds the check-out date of the guest
     */
    public Reservation(String guestName, Room roomReservation, int checkInDate, int checkOutDate, String discountCode) {
        // Assigns the parameters to this class' attributes using the "this" keyword
        this.guestName = guestName;
        this.roomReservation = roomReservation;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.discountCode = discountCode;
        computeTotalPrice(discountCode); // Every reservation made, it will compute the price
    }

    /**
     * showReservationInfo method that displays the guest's reservation information
     *
     * @return string of String values with corresponding information
     */
    public String showReservationInfo() {
        /* Displays the reservation information such as the guest name, room number, check-in and check-out date,
           total days stayed, price per night, and the total price of the whole stay
         */
        return "\n\tGuest Name  : " + getGuestName() + "\n"
                + "\tRoom Number: " + roomReservation.getRoomNumber() + "\n"
                + "\tCheck-in   : December " + getCheckInDate() + ", 2024" +"\n"
                + "\tCheck-out  : December " + getCheckOutDate() + ", 2024" + "\n"
                + "\tTotal Days : " + (this.getCheckOutDate() - this.getCheckInDate()) + "\n"
                + "\tPrice per night: " + roomReservation.getRoomPricePerNight() + "\n"
                + "\tTotal Price: " + getTotalPrice();
    }

    /**
     * computeTotalPrice method that computes the total price of the guest's whole stay
     *
     * @param discountCode - string value that is entered by the user if the user wants a discount
     *
     * @return totalPrice - double value that corresponds to the total price to pay
     */
    public double computeTotalPrice(String discountCode) {
        double discount = 0, basePrice = 0, totalPrice;
        int day;

        for(day = this.checkInDate; day < this.checkOutDate; day++) {
            double priceForDay = roomReservation.getRoomPriceForDay(day);
            basePrice += priceForDay;
        }

        switch(discountCode) {
            case "I_WORK_HERE":
                discount = basePrice * 0.10;
                break;
            case "STAY4_GET1":
                if((this.getCheckOutDate() - this.getCheckInDate()) >= 5) {
                    discount = roomReservation.getRoomPriceForDay(this.getCheckInDate());
                }
                break;
            case "PAYDAY":
                if((this.checkInDate <= 15 && this.checkOutDate != 15) || (this.checkInDate <= 30 && this.checkOutDate != 30)) {
                    discount = basePrice * 0.07;
                }
                break;
            case "":
                discount = 0.0;
                break;
        }

        // Calculate total price after applying discount
        totalPrice = basePrice - discount;

        return totalPrice;
    }

    /**
     * isDateWithinReservation method validates if the date is within the reservation's dates
     *
     * @param date - integer value that holds the date entered by the user
     * @return true or false depending on the condition
     */
    public boolean isDateWithinReservation(int date) {
        // Return true, if the date input is within a reservation's date. Otherwise, false
        return checkInDate <= date && date <= checkOutDate;
    }

    /**
     * infoMatches method checks if the user inputs match the values the attributes hold
     *
     * @param guestName - String value indicating the guest's name
     * @param roomNumber - integer value that holds the room number input
     * @param checkInDate - integer value that holds the check-in date of the guest
     * @param checkOutDate - integer value that holds the check-out date of the guest
     * @return true or false depending on the condition
     */
    public boolean infoMatches(String guestName, int roomNumber, int checkInDate, int checkOutDate) {
        // Returns true, if the parameter inputs match a reservation's information. Otherwise, false
        return this.guestName.equals(guestName) && this.roomReservation.getRoomNumber() == roomNumber && this.checkInDate == checkInDate && this.checkOutDate == checkOutDate;
    }

    /**
     * getGuestName method that returns the String guestName
     *
     * @return guestName - string value that corresponds to the name of the guest
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * getCheckInDate method that returns the integer value of checkInDate
     *
     * @return checkInDate - integer value that corresponds to the guest's desired check-in date
     */
    public int getCheckInDate() {
        return  checkInDate;
    }

    /**
     * getCheckOutDate method that returns the integer value of checkOutDate
     *
     * @return checkOutDate - integer value that corresponds to the guest's desired check-out date
     */
    public int getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * getTotalPrice method that returns the totalPrice of type double
     *
     * @return totalPrice
     */
    public double getTotalPrice() {
        this.totalPrice = computeTotalPrice(this.discountCode);
        return totalPrice;
    }
}
