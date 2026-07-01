package com.stay.hub.dto;

import com.stay.hub.enums.residence.GenderPreferenceType;
import com.stay.hub.enums.residence.OccupancyType;
import com.stay.hub.enums.residence.ResidenceType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResidenceDto {
    private Long id;

    @NotBlank(message = "Residence name is required")
    @Size(min = 3, max = 100, message = "Residence name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @NotNull(message = "Residence type is required")
    private ResidenceType residenceType;

    @NotNull(message = "Gender preference is required")
    private GenderPreferenceType genderPreferenceType;

    @NotNull(message = "Starting rent is required")
    @Positive(message = "Starting rent must be greater than 0")
    private Long startingRent;

    @NotNull(message = "Starting deposit is required")
    @PositiveOrZero(message = "Starting deposit cannot be negative")
    private Long startingDeposit;

    private boolean available = true;

    private Double averageRating;

    private Integer totalReviews;

    @NotEmpty(message = "At least one occupancy rent is required")
    private Map<OccupancyType, Long> rentByOccupancy = new HashMap<>();

    @NotNull(message = "Owner is required")
    private Long ownerId;

    @NotNull(message = "Location is required")
    private LocationDto location;
}
