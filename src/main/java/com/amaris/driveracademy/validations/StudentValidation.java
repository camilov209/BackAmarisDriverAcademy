/*
 * @(#)StudentValidation.java
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
package com.amaris.driveracademy.validations;

import com.amaris.driveracademy.dtos.request.StudentRequestDTO;
import com.google.common.base.Strings;
import com.google.common.primitives.Longs;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * StudentValidation.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 21-05-2022
 */
@Component
@RequiredArgsConstructor
public class StudentValidation {

    /**
     * Valida que los campos requeridos.
     *
     * @param studentRequest {@link StudentRequestDTO}
     * @return {@link Boolean}
     */
    public boolean validateRequiredFieldsStudent(final StudentRequestDTO studentRequest) {
        return Strings.isNullOrEmpty(studentRequest.getStudentName()) ||
            Strings.isNullOrEmpty(studentRequest.getStudentAge()) ||
            Strings.isNullOrEmpty(studentRequest.getStudentIdentification()) ||
            Objects.isNull(studentRequest.getLicense()) ||
            studentRequest.getLicense().getLicenseId() == null;
    }
}