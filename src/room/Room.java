package room;

public abstract class Room {
    private final int roomNumber;
    private final int maxCapacity;
    private int pricePerNight;
    private boolean isReserved;

    public Room(int roomNumber, int maxCapacity, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.pricePerNight = pricePerNight;
        this.isReserved = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}