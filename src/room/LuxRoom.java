package room;

import enums.Prices;

public class LuxRoom extends ProRoom {
    public LuxRoom(int roomNumber) {
        super(roomNumber, 4, Prices.LUX.getPrice());
    }
}