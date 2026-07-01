package com.stay.hub.dto.request;

public record ChangePasswordRequest(
        String userName,
        String email
) {
}
