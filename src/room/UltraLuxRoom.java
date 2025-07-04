package room;

import enums.Prices;

public class UltraLuxRoom extends ProRoom {
    public UltraLuxRoom(int roomNumber) {
        super(roomNumber, 6, Prices.ULTRA_LUX.getPrice());
    }
}