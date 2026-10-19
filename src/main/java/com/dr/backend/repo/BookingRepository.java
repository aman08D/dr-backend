package com.dr.backend.repo;

import com.dr.backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    // Customer ke phone se filter karne ke liye
    List<Booking> findByCustomerPhone(String customerPhone);

    // Specific Status wale bookings (e.g. Sirf PENDING wale admin ke liye)
    List<Booking> findByStatusIgnoreCase(String status);

    // Specific Type ke bookings (e.g. Sirf DOCTOR wale)
    List<Booking> findByBookingTypeIgnoreCase(String bookingType);

}
