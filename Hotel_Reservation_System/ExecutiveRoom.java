package Hotel_Reservation_System;

/**
 * Subclass of Room class.
 */
public class ExecutiveRoom extends Room {
    /**
     * The sole constructor of the Room class.
     *
     * @param roomNumber        - an integer value indicating the room identification or name
     * @param roomPricePerNight - an integer value that stores the price of the room per night
     */
    public ExecutiveRoom(int roomNumber, double roomPricePerNight) {
        super(roomNumber, roomPricePerNight * 1.35, "EXECUTIVE");
    }

    @Override
    public void setRoomPricePerNight(double roomPricePerNight) {
        super.setRoomPricePerNight(roomPricePerNight * 1.35);
    }

    public double getRoomPriceForDay(int day) {
        return getRoomPricePerNight() * getHotelStayed().getDatePriceModifier()[day-1];
    }

    public String getRoomType() {
        return "EXECUTIVE";
    }
}
