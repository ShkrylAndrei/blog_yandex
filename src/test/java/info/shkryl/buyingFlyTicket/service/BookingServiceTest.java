package info.shkryl.buyingFlyTicket.service;

import info.shkryl.buyingFlyTicket.entity.Flight;
import info.shkryl.buyingFlyTicket.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    void setUp() {
        flightRepository.deleteAll();
        flightRepository.save(new Flight("FL123", 1));
    }

    @Transactional
    @Test
    void shouldBookOneTicketSuccessfully() {
        String result = bookingService.bookTicket("FL123");
        assertTrue(result.contains("successfully"), "Результат должен содержать 'successfully'");

        Flight updated = flightRepository.findByFlightNumber("FL123");
        assertNotNull(updated, "Рейс не должен быть null");
        assertEquals(0, updated.getAvailableSeats(), "Должно остаться 0 свободных мест");
    }

    @Test
    void shouldPreventDoubleBookingWithLock() throws InterruptedException {
        flightRepository.save(new Flight("FL-LOCKED", 1));

        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        AtomicInteger successCount = new AtomicInteger();

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                String result = bookingService.bookTicket("FL-LOCKED");
                if (result.contains("successfully")) {
                    successCount.incrementAndGet();
                }
                latch.countDown();
            });
        }

        latch.await(30, TimeUnit.SECONDS);
        executor.shutdown();

        System.out.println("Успешных бронирований (с блокировкой): " + successCount.get());
        assertEquals(1,successCount.get()); // ✅ Только один!
    }
}