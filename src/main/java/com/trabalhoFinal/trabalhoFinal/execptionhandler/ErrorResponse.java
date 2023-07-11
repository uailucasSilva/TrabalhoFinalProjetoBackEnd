package com.trabalhoFinal.trabalhoFinal.execptionhandler;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String code;
    private String message;
    private Long timestamp;
}
