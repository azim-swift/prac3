package service;

import room.Room;
import exception.RoomAlreadyReservedException;

public class BasicRoomServiceImpl<T extends Room> implements RoomService<T> {
    @Override
    public void clean(T room) {
        System.out.println("Уборка комнаты №" + room.getRoomNumber());
    }

    @Override
    public void reserve(T room) {
        if (room.isReserved()) {
            throw new RoomAlreadyReservedException(
                    "Комната №" + room.getRoomNumber() + " уже забронирована!"
            );
        }
        room.setReserved(true);
        System.out.println("Комната №" + room.getRoomNumber() + " забронирована");
    }

    @Override
    public void free(T room) {
        room.setReserved(false);
        System.out.println("Комната №" + room.getRoomNumber() + " освобождена");
    }
}