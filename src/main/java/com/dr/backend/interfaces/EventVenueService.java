package com.dr.backend.interfaces;

import com.dr.backend.model.EventVenue;

import java.util.List;

public interface EventVenueService {

    EventVenue saveEventVenue(EventVenue eventVenue);
    List<EventVenue> getAllEventVenues();
    EventVenue getEventVenueById(Long id);

    // Update done here for 3 parameters
    List<EventVenue> filterEventVenues(String eventType, String serviceType, String district);

    EventVenue updateEventVenue(Long id, EventVenue eventVenue);
    void deleteEventVenue(Long id);
}
