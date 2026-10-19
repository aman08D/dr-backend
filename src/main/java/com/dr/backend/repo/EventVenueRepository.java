package com.dr.backend.repo;

import com.dr.backend.model.EventVenue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventVenueRepository  extends JpaRepository<EventVenue ,Long> {


    // 1. Teeno filter ek sath (eventType + serviceType + district)
    List<EventVenue> findByEventTypeContainingIgnoreCaseAndServiceTypeContainingIgnoreCaseAndDistrictContainingIgnoreCase(
            String eventType, String serviceType, String district);

    // 2. Sirf EventType aur ServiceType
    List<EventVenue> findByEventTypeContainingIgnoreCaseAndServiceTypeContainingIgnoreCase(String eventType, String serviceType);

    // 3. Sirf EventType aur District
    List<EventVenue> findByEventTypeContainingIgnoreCaseAndDistrictContainingIgnoreCase(String eventType, String district);

    // 4. Sirf ServiceType aur District
    List<EventVenue> findByServiceTypeContainingIgnoreCaseAndDistrictContainingIgnoreCase(String serviceType, String district);

    // 5. Sirf Single Filters
    List<EventVenue> findByEventTypeContainingIgnoreCase(String eventType);
    List<EventVenue> findByServiceTypeContainingIgnoreCase(String serviceType);
    List<EventVenue> findByDistrictContainingIgnoreCase(String district);
}
