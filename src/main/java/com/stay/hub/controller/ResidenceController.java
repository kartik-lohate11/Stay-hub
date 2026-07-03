package com.stay.hub.controller;

import com.stay.hub.dto.ResidenceDto;
import com.stay.hub.dto.request.ResidenceRequest;
import com.stay.hub.dto.request.ResidenceSearchRequest;
import com.stay.hub.service.ResidenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residence")
@RequiredArgsConstructor
public class ResidenceController {

    private final ResidenceService residenceService;

    /**
     * Create Residence
     */
    @PostMapping
    public ResponseEntity<ResidenceDto> createResidence(
            @Valid @RequestBody ResidenceRequest request) {

        ResidenceDto response = residenceService.createResidence(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    /**
     * Update Residence
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResidenceDto> updateResidence(
            @PathVariable Long id,
            @Valid @RequestBody ResidenceRequest request) {

        return ResponseEntity.ok(
                residenceService.updateResidence(id, request));
    }

    /**
     * Get Residence By Id
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResidenceDto> getResidence(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                residenceService.getResidence(id));
    }

    /**
     * Get All Residences
     */
    @GetMapping
    public ResponseEntity<List<ResidenceDto>> getAllResidences() {

        return ResponseEntity.ok(
                residenceService.getAllResidences());
    }

    /**
     * Delete Residence
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResidence(
            @PathVariable Long id) {

        residenceService.deleteResidence(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Search Residence
     */
    @PostMapping("/search")
    public ResponseEntity<Page<ResidenceDto>> searchResidence(
            @RequestBody ResidenceSearchRequest request,
            Pageable pageable) {

        return ResponseEntity.ok(
                residenceService.searchResidence(request, pageable));
    }
}
