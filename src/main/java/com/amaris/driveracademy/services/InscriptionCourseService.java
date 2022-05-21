/*
 * @(#)InscriptionCourseService.java
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
package com.amaris.driveracademy.services;

import com.amaris.driveracademy.dtos.request.InscriptionCourseRequestDTO;
import org.springframework.http.ResponseEntity;

/**
 * InscriptionCourseService.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 20-05-2022
 */
public interface InscriptionCourseService {

    /**
     * Inscripción a modulos y cursos.
     *
     * @param inscriptionCourses {@link InscriptionCourseRequestDTO}
     * @return {@link Void}
     */
    ResponseEntity<Void> insertInscriptionCourse(InscriptionCourseRequestDTO inscriptionCourses);
}