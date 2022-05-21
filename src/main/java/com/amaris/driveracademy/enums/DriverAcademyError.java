/*
 * @(#)DriverAcademyError.java
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

import lombok.RequiredArgsConstructor;

/**
 * DriverAcademyError.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@RequiredArgsConstructor
public enum DriverAcademyError implements EnumError {
    /** DEFAULT. */
    DEFAULT("99", "Error Generico"),
    /** ERROR_STUDENT_EXIST. */
    ERROR_STUDENT_EXIST("01", "El estudiante ya se encuentra registrado"),
    /** ERROR_EMPTY_STUDENTS. */
    ERROR_EMPTY_STUDENTS("02", "No se encontraron estudiantes registrados."),
    /** ERROR_EMPTY_MODULE. */
    ERROR_EMPTY_MODULE("03", "No se encontraron modulos registrados"),
    /** ERROR_EMPTY_LICENSES. */
    ERROR_EMPTY_LICENSES("04", "No se encontraron tipos de licencias registradas"),
    /** ERROR_EXIST_INSCRIPTION. */
    ERROR_EXIST_INSCRIPTION("05", "El estudiante ya tiene un curso registrado."),
    /** ERROR_NOT_EXITS_MODULE_COURSE. */
    ERROR_NOT_EXITS_MODULE_COURSE("06", "El estudiante, módulo o curso no existe."),
    /** ERROR_NOT_COINCIDE_COURSE_MODULE. */
    ERROR_NOT_COINCIDE_COURSE_MODULE("07", "El curso no pertenece a un módulo."),
    /** ERROR_REQUIRED_FIELDS. */
    ERROR_REQUIRED_FIELDS("08", "Hay parámetros requeridos sin diligenciar.");

    /** code. */
    private final String code;
    /** message. */
    private final String message;

    // -------------------------------------------------------------------
    // -- Métodos Sobrescritos -------------------------------------------
    // -------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public String getCode() {
        return "DA" + this.code;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return this.message;
    }

    // -------------------------------------------------------------------
    // -- Métodos Públicos -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Obtiene errores por código.
     *
     * @param code {@link String}
     * @return {@link DriverAcademyError}
     */
    public static DriverAcademyError getErrorByCode(final String code) {
        for (final DriverAcademyError error : DriverAcademyError.values()) {
            if (error.getCode().equalsIgnoreCase(code)) {
                return error;
            }
        }
        return DEFAULT;
    }

}