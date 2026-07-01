package com.stay.hub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LocationDto {

    private Long id;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Address is required")
    @Size(min = 10, max = 255, message = "Address must be between 10 and 255 characters")
    private String address;

    @NotBlank(message = "Pin code is required")
    @Pattern(regexp = "^[1-9][0-9]{5}$",
            message = "Please enter a valid 6-digit Indian PIN code")
    private String pinCode;

    @NotBlank(message = "Latitude is required")
    @Pattern(
            regexp = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)$",
            message = "Invalid latitude"
    )
    private String latitude;

    @NotBlank(message = "Longitude is required")
    @Pattern(
            regexp = "^[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$",
            message = "Invalid longitude"
    )
    private String longitude;
}
