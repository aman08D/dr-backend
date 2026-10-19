package com.dr.backend.serviceImpl;


import com.dr.backend.interfaces.EventVenueService;
import com.dr.backend.model.EventVenue;
import com.dr.backend.repo.EventVenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EventVenueServiceImpl implements EventVenueService {

    @Autowired
    private EventVenueRepository eventVenueRepository;
    @Override
    public EventVenue saveEventVenue(EventVenue eventVenue) {
       if (eventVenue.getIsAvailable()==null){
           eventVenue.setIsAvailable(true);
       }
        return eventVenueRepository.save(eventVenue);
    }

    @Override
    public List<EventVenue> getAllEventVenues() {
       return  eventVenueRepository.findAll();


    }

    @Override
    public EventVenue getEventVenueById(Long id) {

        return eventVenueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event Venue not found with id: " + id));
    }

    @Override
    public List<EventVenue> filterEventVenues(String eventType ,String serviceType, String district) {
        if (serviceType != null && district != null && eventType !=null) {
            return eventVenueRepository.findByEventTypeContainingIgnoreCaseAndServiceTypeContainingIgnoreCaseAndDistrictContainingIgnoreCase(eventType,serviceType,district);
        } else if (district != null && eventType !=null ) {
            return eventVenueRepository.findByEventTypeContainingIgnoreCaseAndDistrictContainingIgnoreCase(eventType,district);


        } else if (district !=null && serviceType !=null){
            return eventVenueRepository.findByServiceTypeContainingIgnoreCaseAndDistrictContainingIgnoreCase(serviceType,district);
        }else if(eventType !=null && serviceType !=null ){
            return  eventVenueRepository.findByEventTypeContainingIgnoreCaseAndServiceTypeContainingIgnoreCase(eventType,serviceType);
        }



        else if (district != null) {
            return eventVenueRepository.findByDistrictContainingIgnoreCase(district);
        } else if (eventType !=null) {
            return eventVenueRepository.findByEventTypeContainingIgnoreCase(eventType);
        } else if (serviceType !=null) {
            return  eventVenueRepository.findByServiceTypeContainingIgnoreCase(serviceType);
        }
        return getAllEventVenues();
    }

    @Override
    public EventVenue updateEventVenue(Long id, EventVenue eventVenueDetails) {
        EventVenue existing = getEventVenueById(id);
        existing.setName(eventVenueDetails.getName());
        existing.setServiceType(eventVenueDetails.getServiceType());
        existing.setDistrict(eventVenueDetails.getDistrict());
        existing.setAddress(eventVenueDetails.getAddress());
        existing.setCapacity(eventVenueDetails.getCapacity());
        existing.setPricePerDay(eventVenueDetails.getPricePerDay());
        existing.setContactNumber(eventVenueDetails.getContactNumber());
        existing.setDescription(eventVenueDetails.getDescription());
        existing.setImageUrl(eventVenueDetails.getImageUrl());
        existing.setIsAvailable(eventVenueDetails.getIsAvailable()); // isAvailable ke liye
        return eventVenueRepository.save(existing);
    }

    @Override
    public void deleteEventVenue(Long id) {
        eventVenueRepository.deleteById(id);

    }
}
