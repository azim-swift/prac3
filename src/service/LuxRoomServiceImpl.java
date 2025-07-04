package service;

import room.ProRoom;
import exception.RoomAlreadyReservedException;

public class LuxRoomServiceImpl<T extends ProRoom> implements LuxRoomService<T> {
    private final BasicRoomServiceImpl<T> basicService = new BasicRoomServiceImpl<>();

    @Override
    public void clean(T room) {
        basicService.clean(room);
    }

    @Override
    public void reserve(T room) {
        basicService.reserve(room);
    }

    @Override
    public void free(T room) {
        basicService.free(room);
    }

    @Override
    public void foodDelivery(T room, String order) {
        if (!room.isReserved()) {
            throw new IllegalStateException(
                    "Комната должна быть забронирована для заказа еды!"
            );
        }
        System.out.println("Доставка еды в комнату №" +
                room.getRoomNumber() + ": " + order);
    }
}