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
import com.amaris.driveracademy.enums.DriverAcademyError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.repositories.CourseRepository;
import com.amaris.driveracademy.repositories.InscriptionCourseRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
    /** courseRepository. */
    private final CourseRepository courseRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<InscriptionCourses> insertInscriptionCourse(final List<InscriptionCourses> inscriptionCourses) {
        try {
            final var idStudents = new ArrayList<Long>();
            final var idModules = new ArrayList<Long>();
            final var idCourses = new ArrayList<Long>();
            inscriptionCourses.forEach(inscription -> {
                idStudents.add(inscription.getStudents().getStudentId());
                idModules.add(inscription.getModules().getModuleId());
                idCourses.add(inscription.getCourses().getCourseId());
            });
            final var isNotValidCourseInModule =
                this.courseRepository.getCoursesByIdAndModuleId(idCourses, idModules);
            if(isNotValidCourseInModule.size() < inscriptionCourses.size()) {
                throw new SimpleException(DriverAcademyError.ERROR_NOT_COINCIDE_COURSE_MODULE, HttpStatus.BAD_REQUEST.value());
            }else {
                final var idStudent = this.inscriptionCourseRepository
                    .findByModuleIdAndStudentId(idStudents, idModules);
                if(!idStudent.isEmpty()) {
                    throw new SimpleException(DriverAcademyError.ERROR_EXIST_INSCRIPTION, HttpStatus.BAD_REQUEST.value());
                }
                return this.inscriptionCourseRepository.saveAllAndFlush(inscriptionCourses);
            }
        }catch (DataIntegrityViolationException integrityViolationException) {
            throw new SimpleException(DriverAcademyError.ERROR_NOT_EXITS_MODULE_COURSE, HttpStatus.BAD_REQUEST.value(),
                integrityViolationException);
        }
        catch (final Exception ex) {
            throw new SimpleException(CommonError.INTERMITTENT_SERVICE, HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

}