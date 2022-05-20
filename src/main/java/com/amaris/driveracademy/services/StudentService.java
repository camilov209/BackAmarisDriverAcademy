/*
 * @(#)StudentService.java
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

import com.amaris.driveracademy.dtos.request.StudentRequestDTO;
import com.amaris.driveracademy.dtos.response.StudentDetailResponseDTO;
import com.amaris.driveracademy.dtos.response.StudentsResponseDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * StudentService.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
public interface StudentService {

    /**
     * Inserta un estudiante.
     *
     * @param studentRequest {@link StudentRequestDTO}
     * @return {@link Void}
     */
    ResponseEntity<Void> insertStudent(StudentRequestDTO studentRequest);

    /**
     * Obtiene todos los estudiantes.
     *
     * @return {@link StudentsResponseDTO}
     */
    List<StudentsResponseDTO> getAllStudents();

    /**
     * Obtiene el detalle del estudiante.
     *
     * @return {@link StudentsResponseDTO}
     */
    StudentDetailResponseDTO getDetailStudent(long id);
}