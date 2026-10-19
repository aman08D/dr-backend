package com.dr.backend.controller;


import com.dr.backend.interfaces.EventVenueService;
import com.dr.backend.model.EventVenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*") // Frontend ko connect karne ke liye
public class EventVenueController {

    @Autowired
    private EventVenueService eventVenueService;

    @PostMapping

    public ResponseEntity<EventVenue>createEventVenue(@RequestBody EventVenue eventVenue) {


        return  ResponseEntity.ok(eventVenueService.saveEventVenue(eventVenue));
    }

    // 2. Get All
    @GetMapping
    public ResponseEntity<List<EventVenue>> getAllEventVenues() {
        return ResponseEntity.ok(eventVenueService.getAllEventVenues());
    }

    // 3. Filter by ServiceType and District (/api/events/filter?serviceType=Venue&district=Patna)
    @GetMapping("/filter")
    public ResponseEntity<List<EventVenue>> filterEventVenues(
            @RequestParam(required = false) String serviceType,
            @RequestParam(required = false) String district,
            @RequestParam(required = false) String eventType) {
        return ResponseEntity.ok(eventVenueService.filterEventVenues(serviceType, district,eventType));
    }

    // 4. Update
    @PutMapping("/{id}")
    public ResponseEntity<EventVenue> updateEventVenue(@PathVariable Long id, @RequestBody EventVenue eventVenue) {
        return ResponseEntity.ok(eventVenueService.updateEventVenue(id, eventVenue));
    }

    // 5. Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEventVenue(@PathVariable Long id) {
        eventVenueService.deleteEventVenue(id);
        return ResponseEntity.ok("Event/Venue deleted successfully!");
    }





    }






