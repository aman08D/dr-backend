package com.dr.backend.interfaces;

import com.dr.backend.model.Booking;

import java.util.List;

public interface BookingService {

    Booking createBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    List<Booking> getBookingsByPhone(String phone);
    List<Booking> getBookingsByStatus(String status);
    Booking updateBookingStatus(Long id, String status);
    void deleteBooking(Long id);
}
