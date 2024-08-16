package Hotel_Reservation_System;

/**
 * Subclass of Room class.
 */
public class StandardRoom extends Room{
    /**
     * The sole constructor of the Room class.
     *
     * @param roomNumber        - an integer value indicating the room identification or name
     * @param roomPricePerNight - an integer value that stores the price of the room per night
     */
    public StandardRoom(int roomNumber, double roomPricePerNight) {
        super(roomNumber, roomPricePerNight, "STANDARD");
    }

    @Override
    public void setRoomPricePerNight(double roomPricePerNight) {
        super.setRoomPricePerNight(roomPricePerNight);
    }

    public double getRoomPriceForDay(int day) {
        return getRoomPricePerNight() * getHotelStayed().getDatePriceModifier()[day-1];
    }

    public String getRoomType() {
        return "STANDARD";
    }
}


