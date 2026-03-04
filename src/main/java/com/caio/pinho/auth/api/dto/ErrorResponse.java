package com.caio.pinho.auth.api.dto;

import java.util.Map;

public record ErrorResponse(
        String code,
        String message,
        Map<String, String> details
) {
    public static ErrorResponse simple(String code, String message) {
        return new ErrorResponse(code, message, null);
    }
}
