package Hotel_Reservation_System;

import java.util.List;

/**
 * Interface for Room class.
 */
public interface Reservable {
    boolean isBooked();
    void makeReservation(String guestName, int checkInDate, int checkOutDate, String discountCode);
    boolean removeReservation(String guestName, int checkIn, int checkOut);
    String showReservationStatus(String guestName, int checkIn, int checkOut);
    List<Reservation> getReservation();
}
