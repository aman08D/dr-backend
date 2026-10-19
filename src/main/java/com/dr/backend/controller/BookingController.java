package com.dr.backend.controller;


import com.dr.backend.interfaces.BookingService;
import com.dr.backend.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")

public class BookingController {

    @Autowired
    private BookingService bookingService;

    // 1. Create New Booking/Enquiry
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }


    // 2. Get All Bookings (Admin Panel ke liye)
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // 3. Get Booking by Phone (Customer ke history ke liye)
    @GetMapping("/phone/{phone}")
    public ResponseEntity<List<Booking>> getBookingsByPhone(@PathVariable String phone) {
        return ResponseEntity.ok(bookingService.getBookingsByPhone(phone));
    }

    // 4. Get Bookings by Status (/api/bookings/status/PENDING)
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Booking>> getBookingsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(bookingService.getBookingsByStatus(status));
    }

    // 5. Update Status (Admin can mark: "CONFIRMED" or "CANCELLED")
    @PutMapping("/{id}/status")
    public ResponseEntity<Booking> updateBookingStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(bookingService.updateBookingStatus(id, status));
    }

    // 6. Delete Booking
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully!");
    }



}
