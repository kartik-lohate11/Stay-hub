package com.stay.hub.repository;

import com.stay.hub.entity.ResidenceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResidenceRepository extends JpaRepository<ResidenceData,Long> ,
        JpaSpecificationExecutor<ResidenceData> {
}
