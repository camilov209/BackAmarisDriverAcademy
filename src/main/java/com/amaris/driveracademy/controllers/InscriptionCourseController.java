/*
 * @(#)InscriptionCourseController.java
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
package com.amaris.driveracademy.controllers;

import com.amaris.driveracademy.dtos.request.InscriptionCourseRequestDTO;
import com.amaris.driveracademy.dtos.response.LicensesResponseDTO;
import com.amaris.driveracademy.enums.CommonError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.services.InscriptionCourseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * InscriptionCourseController.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 20-05-2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "inscription", produces = MediaType.APPLICATION_JSON_VALUE)
public class InscriptionCourseController {

    /** inscriptionCourseService. */
    private final InscriptionCourseService inscriptionCourseService;

    /**
     * Servicio que registra los modulos y cursos del estudiante.
     *
     * @return {@link LicensesResponseDTO}
     */
    @PostMapping
    public ResponseEntity<Void> insertInscriptionCourse(@RequestBody final List<InscriptionCourseRequestDTO> inscription) {
        return this.inscriptionCourseService.insertInscriptionCourse(inscription);
    }
}