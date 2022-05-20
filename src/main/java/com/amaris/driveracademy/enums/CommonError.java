/*
 * @(#)CommonError.java
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
package com.amaris.driveracademy.enums;

/**
 * CommonError.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
public enum CommonError implements EnumError {
    /** DEFAULT. */
    DEFAULT("99", "Error generico"),
    /** INVALID_ARGS. */
    INVALID_ARGS("01", "Argumentos invalidos"),
    /** NOT_ALLOWED. */
    NOT_ALLOWED("02", "Método no permitido"),
    /** INVALID_BODY. */
    INVALID_BODY("03", "Cuerpo de la petición invalida"),
    /** INVALID_BODY. */
    INTERMITTENT_SERVICE("04", "El servicio presenta intermitencia, intenta más tarde.");

    /** code. */
    private final String code;
    /** message. */
    private final String message;

    /**
     * {@inheritDoc}
     */
    public String getCode() {
        return "DA" + this.code;
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Constructor de errores comunes.
     *
     * @param code {@link String}
     * @param message {@link String}
     */
    CommonError(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}