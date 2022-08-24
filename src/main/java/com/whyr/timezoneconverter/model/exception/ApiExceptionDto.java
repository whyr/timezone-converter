package com.whyr.timezoneconverter.model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiExceptionDto {

    private int statusCode;
    private String statusMessage;
    private String errorMessage;

}
