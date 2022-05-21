/*
 * @(#)InscriptionCourseValidation.java
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

import com.amaris.driveracademy.dtos.request.InscriptionCourseRequestDTO;
import com.amaris.driveracademy.dtos.request.StudentRequestDTO;
import com.amaris.driveracademy.dtos.response.ModulesDetailResponseDTO;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * InscriptionCourseValidation.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 21-05-2022
 */
@Component
@RequiredArgsConstructor
public class InscriptionCourseValidation {
    /**
     * Valida que los campos requeridos.
     *
     * @param inscriptionCourseRequest {@link InscriptionCourseRequestDTO}
     * @return {@link Boolean}
     */
    public boolean validateRequiredFieldsInscription(final InscriptionCourseRequestDTO inscriptionCourseRequest) {
        return inscriptionCourseRequest.getStudents().getStudentId() == null ||
            validateRequiredFieldsList(inscriptionCourseRequest.getModules());

    }

    /**
     * Valida que la lista no tenga datos null.
     *
     * @param modules {@link ModulesDetailResponseDTO}
     * @return {@link Boolean}
     */
    private boolean validateRequiredFieldsList(final List<ModulesDetailResponseDTO> modules) {
        final AtomicInteger countRequired = new AtomicInteger();
        modules.forEach(module -> {
            if(module.getModuleId() == null || module.getCourses().getCourseId() == null) {
                countRequired.getAndIncrement();
            }
        });
        return countRequired.get() > 0;
    }
}