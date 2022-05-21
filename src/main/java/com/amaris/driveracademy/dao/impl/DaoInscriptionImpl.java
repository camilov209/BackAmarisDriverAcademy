/*
 * @(#)DaoInscriptionImpl.java
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
package com.amaris.driveracademy.dao.impl;

import com.amaris.driveracademy.dao.DaoInscriptionCourse;
import com.amaris.driveracademy.entities.InscriptionCourses;
import com.amaris.driveracademy.enums.CommonError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.repositories.InscriptionCourseRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

/**
 * DaoInscriptionImpl.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 20-05-2022
 */
@Repository
@AllArgsConstructor
public class DaoInscriptionImpl implements DaoInscriptionCourse {

    /** inscriptionCourseRepository. */
    private final InscriptionCourseRepository inscriptionCourseRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<InscriptionCourses> insertInscriptionCourse(final List<InscriptionCourses> inscriptionCourses) {
        try {
            return this.inscriptionCourseRepository.saveAllAndFlush(inscriptionCourses);
        }catch (final Exception ex) {
            throw new SimpleException(CommonError.INTERMITTENT_SERVICE, HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

}