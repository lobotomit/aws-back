package com.ereyesalvarez.aws.calculator.app.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorOut {
    private int code;
    private String message;
}
