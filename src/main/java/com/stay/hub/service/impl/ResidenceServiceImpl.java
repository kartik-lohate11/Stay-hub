package com.stay.hub.service.impl;

import com.stay.hub.dto.ResidenceDto;
import com.stay.hub.dto.mapper.ResidenceMapper;
import com.stay.hub.dto.request.ResidenceRequest;
import com.stay.hub.dto.request.ResidenceSearchRequest;
import com.stay.hub.entity.ResidenceData;
import com.stay.hub.exception.ResidenceNotFoundException;
import com.stay.hub.repository.ResidenceRepository;
import com.stay.hub.service.ResidenceService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ResidenceServiceImpl implements ResidenceService {

    private final ResidenceRepository repository;
    private final ResidenceMapper residenceMapper;

    @Override
    public ResidenceDto createResidence(ResidenceRequest request) {

        ResidenceData residence = residenceMapper.toEntity(request.residenceDto());

        ResidenceData savedResidence = repository.save(residence);

        return residenceMapper.toDto(savedResidence);
    }

    @Override
    public ResidenceDto updateResidence(Long id, ResidenceRequest request) {

        ResidenceData residence = repository.findById(id)
                .orElseThrow(() ->
                        new ResidenceNotFoundException(
                                "Residence not found with id : " + id));

        residenceMapper.updateEntityFromDto(request.residenceDto(), residence);

        ResidenceData updatedResidence = repository.save(residence);

        return residenceMapper.toDto(updatedResidence);
    }

    @Override
    @Transactional(readOnly = true)
    public ResidenceDto getResidence(Long id) {

        ResidenceData residence = repository.findById(id)
                .orElseThrow(() ->
                        new ResidenceNotFoundException(
                                "Residence not found with id : " + id));

        return residenceMapper.toDto(residence);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResidenceDto> getAllResidences() {

        return repository.findAll()
                .stream()
                .map(residenceMapper::toDto)
                .toList();
    }

    @Override
    public void deleteResidence(Long id) {

        ResidenceData residence = repository.findById(id)
                .orElseThrow(() ->
                        new ResidenceNotFoundException(
                                "Residence not found with id : " + id));

        repository.delete(residence);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ResidenceDto> searchResidence(ResidenceSearchRequest request,
                                              Pageable pageable) {

        return null;
    }
}
