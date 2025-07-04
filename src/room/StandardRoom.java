package room;

import enums.Prices;

public class StandardRoom extends Room {
    public StandardRoom(int roomNumber) {
        super(roomNumber, 3, Prices.STANDARD.getPrice());
    }
}