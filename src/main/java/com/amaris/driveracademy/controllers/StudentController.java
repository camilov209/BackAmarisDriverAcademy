/*
 * @(#)StudentController.java
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

import com.amaris.driveracademy.dtos.request.StudentRequestDTO;
import com.amaris.driveracademy.dtos.response.StudentsResponseDTO;
import com.amaris.driveracademy.enums.DriverAcademyError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.services.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentController.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    /** studentService. */
    private final StudentService studentService;

    /**
     * Insert student.
     *
     * @param studentRequest {@link StudentRequestDTO}
     * @return {@link Void}
     */
    @PostMapping
    public ResponseEntity<Void> insertStudent(@RequestBody final StudentRequestDTO studentRequest) {
        return this.studentService.insertStudent(studentRequest);
    }

    @GetMapping
    public List<StudentsResponseDTO> getAllStudents() {
        return this.studentService.getAllStudents();
    }
}