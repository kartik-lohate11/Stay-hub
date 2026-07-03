package com.stay.hub.repository;

import com.stay.hub.entity.LocationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationData,Long> {
}
