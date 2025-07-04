import room.*;
import service.*;
import exception.RoomAlreadyReservedException;

public class HotelTest {
    public static void main(String[] args) {
        // Создаем сервисы
        RoomService<Room> basicService = new BasicRoomServiceImpl<>();
        LuxRoomService<ProRoom> luxService = new LuxRoomServiceImpl<>();

        // Тестируем разные типы комнат
        System.out.println("===== ТЕСТИРОВАНИЕ СИСТЕМЫ ОТЕЛЯ =====");
        testEconomyRoom(basicService);
        testStandardRoom(basicService);
        testLuxRoom(luxService);
        testUltraLuxRoom(luxService);
        testInvalidOperations(luxService);
    }

    private static void testEconomyRoom(RoomService<Room> service) {
        System.out.println("\n--- Тестирование Economy Room ---");
        EconomyRoom room = new EconomyRoom(101);

        System.out.println("1. Уборка комнаты:");
        service.clean(room);

        System.out.println("2. Бронирование комнаты:");
        service.reserve(room);

        System.out.println("3. Попытка повторного бронирования:");
        try {
            service.reserve(room);
        } catch (RoomAlreadyReservedException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        System.out.println("4. Освобождение комнаты:");
        service.free(room);
    }

    private static void testStandardRoom(RoomService<Room> service) {
        System.out.println("\n--- Тестирование Standard Room ---");
        StandardRoom room = new StandardRoom(201);

        System.out.println("1. Уборка комнаты:");
        service.clean(room);

        System.out.println("2. Бронирование комнаты:");
        service.reserve(room);

        System.out.println("3. Попытка повторного бронирования:");
        try {
            service.reserve(room);
        } catch (RoomAlreadyReservedException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        System.out.println("4. Освобождение комнаты:");
        service.free(room);
    }

    private static void testLuxRoom(LuxRoomService<ProRoom> service) {
        System.out.println("\n--- Тестирование Lux Room ---");
        LuxRoom room = new LuxRoom(301);

        System.out.println("1. Базовые операции:");
        service.clean(room);
        service.reserve(room);

        System.out.println("2. Дополнительные услуги:");
        service.foodDelivery(room, "Икра черная, шампанское");

        System.out.println("3. Освобождение комнаты:");
        service.free(room);
    }

    private static void testUltraLuxRoom(LuxRoomService<ProRoom> service) {
        System.out.println("\n--- Тестирование Ultra Lux Room ---");
        UltraLuxRoom room = new UltraLuxRoom(401);

        System.out.println("1. Базовые операции:");
        service.clean(room);
        service.reserve(room);

        System.out.println("2. Дополнительные услуги:");
        service.foodDelivery(room, "Дорогая закуска с трюфелями");

        System.out.println("3. Освобождение комнаты:");
        service.free(room);
    }

    private static void testInvalidOperations(LuxRoomService<ProRoom> service) {
        System.out.println("\n--- Тестирование некорректных операций ---");

        // Попытка использовать люксовый сервис с обычной комнатой
        System.out.println("1. Попытка заказа еды в обычную комнату:");


        // Попытка заказа еды в незабронированную комнату
        System.out.println("2. Попытка заказа еды без бронирования:");
        try {
            LuxRoom luxRoom = new LuxRoom(301);
            service.foodDelivery(luxRoom, "Суши");
        } catch (IllegalStateException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }
    }
}