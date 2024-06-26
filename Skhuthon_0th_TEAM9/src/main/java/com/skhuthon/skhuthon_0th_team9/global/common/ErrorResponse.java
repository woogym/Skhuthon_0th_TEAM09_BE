package com.skhuthon.skhuthon_0th_team9.global.common;

import com.skhuthon.skhuthon_0th_team9.global.common.exception.ErrorCode;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ErrorResponse {

    private int status;
    private String name;
    private String message;

    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(errorCode.getHttpStatus().value())
                        .name(errorCode.name())
                        .message(errorCode.getMessage())
                        .build()
                );
    }

    public static ErrorResponse of(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .status(errorCode.getHttpStatus().value())
                .name(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }
}
