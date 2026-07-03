package com.stay.hub.service;

import com.stay.hub.dto.ResidenceDto;
import com.stay.hub.dto.request.ResidenceRequest;
import com.stay.hub.dto.request.ResidenceSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ResidenceService {
    ResidenceDto createResidence(ResidenceRequest request);

    ResidenceDto updateResidence(Long id,
                                 ResidenceRequest request);

    ResidenceDto getResidence(Long id);

    List<ResidenceDto> getAllResidences();

    void deleteResidence(Long id);

    Page<ResidenceDto> searchResidence(
            ResidenceSearchRequest request,
            Pageable pageable);
}
