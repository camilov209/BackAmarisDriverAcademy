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

import com.amaris.driveracademy.enums.DriverAcademyError;
import com.amaris.driveracademy.enums.EnumError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * SimpleException.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@Getter
@Setter
@JsonIgnoreProperties({"cause", "stackTrace", "localizedMessage", "suppressed", "status", "errorEnum"})
public class SimpleException extends RuntimeException {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;
    /** status. */
    private final int status;
    /** code. */
    private final String code;
    /** errorEnum. */
    private final EnumError errorEnum;
    /** source. */
    private final String source;

    /**
     * Constructor.
     *
     * @param enumError {@link EnumError}
     */
    public SimpleException(final EnumError enumError) {
        this(enumError, null);
    }

    /**
     * Constructor.
     *
     * @param enumError {@link EnumError}
     * @param cause {@link Throwable}
     */
    public SimpleException(final EnumError enumError, final Throwable cause) {
        this(enumError, 500, cause);
    }

    /**
     * Constructor.
     *
     * @param enumError {@link EnumError}
     * @param httpStatus {@link Integer}
     */
    public SimpleException(final EnumError enumError, final int httpStatus) {
        this(enumError, httpStatus, null);
    }

    /**
     * Constructor.
     *
     * @param enumError {@link EnumError}
     * @param httpStatus {@link Integer}
     * @param cause {@link Throwable}
     */
    public SimpleException(final EnumError enumError, final int httpStatus, final Throwable cause) {
        super(enumError.getMessage(), cause);
        this.source = SimpleException.class.getName();
        this.errorEnum = enumError;
        this.status = httpStatus;
        this.code = enumError.getCode();
    }

    /**
     * Constructor.
     *
     * @param m {@link Map}
     * @param httpStatus {@link Integer}
     * @param cause {@link Throwable}
     */
    private SimpleException(final Map<String, String> m, final int httpStatus, final Throwable cause) {
        super(m.get("message"), cause);
        this.source = SimpleException.class.getName();
        this.errorEnum = DriverAcademyError.DEFAULT;
        this.code = m.get("code");
        this.status = httpStatus;
    }

}