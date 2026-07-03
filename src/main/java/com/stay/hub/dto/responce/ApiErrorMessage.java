package com.stay.hub.dto.responce;

public record ApiErrorMessage(
        String message,
        String status
) {
}
