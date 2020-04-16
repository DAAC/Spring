package com.daac.mx.restful.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
