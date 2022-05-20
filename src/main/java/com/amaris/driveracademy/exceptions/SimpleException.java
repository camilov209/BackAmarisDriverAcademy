/*
 * @(#)SimpleException.java
 *
 * Copyright (c) BANCO DE CHILE (Chile). All rights reserved.
 *
 * All rights to this product are owned by BANCO DE CHILE and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by BANCO DE CHILE.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.amaris.driveracademy.exceptions;

import com.amaris.driveracademy.enums.CommonError;
import com.amaris.driveracademy.enums.DriverAcademyError;
import com.amaris.driveracademy.enums.EnumError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * SimpleException.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@JsonIgnoreProperties({"cause", "stackTrace", "localizedMessage", "suppressed", "status", "errorEnum"})
public class SimpleException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final int status;
    private final String code;
    private final EnumError errorEnum;
    private final String source;


    public SimpleException(final EnumError enumError) {
        this(enumError, (Throwable)null);
    }

    public SimpleException(final EnumError enumError, final Throwable cause) {
        this((EnumError)enumError, 500, cause);
    }

    public SimpleException(final EnumError enumError, final int httpStatus) {
        this((EnumError)enumError, httpStatus, (Throwable)null);
    }

    public SimpleException(final EnumError enumError, final int httpStatus, final Throwable cause) {
        super(enumError.getMessage(), cause);
        this.source = SimpleException.class.getName();
        this.errorEnum = enumError;
        this.status = httpStatus;
        this.code = enumError.getCode();
    }

    private SimpleException(final Map<String, String> m, final int httpStatus, final Throwable cause) {
        super((String)m.get("message"), cause);
        this.source = SimpleException.class.getName();
        this.errorEnum = DriverAcademyError.DEFAULT;
        this.code = (String)m.get("code");
        this.status = httpStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public EnumError getErrorEnum() {
        return this.errorEnum;
    }

    public String getSource() {
        return this.source;
    }

}