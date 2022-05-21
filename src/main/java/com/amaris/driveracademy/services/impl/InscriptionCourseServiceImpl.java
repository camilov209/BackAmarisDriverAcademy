/*
 * @(#)InscriptionCourseServiceImpl.java
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
package com.amaris.driveracademy.services.impl;

import com.amaris.driveracademy.dao.DaoInscriptionCourse;
import com.amaris.driveracademy.dtos.request.InscriptionCourseRequestDTO;
import com.amaris.driveracademy.entities.InscriptionCourses;
import com.amaris.driveracademy.entities.Modules;
import com.amaris.driveracademy.enums.DriverAcademyError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.services.InscriptionCourseService;
import com.amaris.driveracademy.validations.InscriptionCourseValidation;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * InscriptionCourseServiceImpl.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 20-05-2022
 */
@Service
@AllArgsConstructor
public class InscriptionCourseServiceImpl implements InscriptionCourseService {

    /** modelMapper. */
    private final ModelMapper modelMapper;
    /** daoInscriptionCourse. */
    private final DaoInscriptionCourse daoInscriptionCourse;
    private final InscriptionCourseValidation inscriptionCourseValidation;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> insertInscriptionCourse(final InscriptionCourseRequestDTO inscriptionCourses) {
        if(this.inscriptionCourseValidation.validateRequiredFieldsInscription(inscriptionCourses)) {
            throw new SimpleException(DriverAcademyError.ERROR_REQUIRED_FIELDS, HttpStatus.BAD_REQUEST.value());
        }
        final var inscriptionCourseMapperList = new ArrayList<InscriptionCourses>();
        inscriptionCourses.getModules().forEach(inscription -> {
            final var inscriptionCourseMapper = new InscriptionCourses();
            inscriptionCourseMapper.setStudents(inscriptionCourses.getStudents());
            inscriptionCourseMapper.setModules(this.modelMapper.map(inscription, Modules.class));
            inscriptionCourseMapper.setCourses(inscription.getCourses());
            inscriptionCourseMapperList.add(inscriptionCourseMapper);
        });
        this.daoInscriptionCourse.insertInscriptionCourse(inscriptionCourseMapperList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}