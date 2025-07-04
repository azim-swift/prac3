package room;

import enums.Prices;

public class EconomyRoom extends Room {
    public EconomyRoom(int roomNumber) {
        super(roomNumber, 2, Prices.ECONOMY.getPrice());
    }
}