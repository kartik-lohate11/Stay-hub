package com.stay.hub.repository;

import com.stay.hub.entity.ReviewData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewData,Long> {
    List<ReviewData> findByResidenceId(Long residenceId);
}
