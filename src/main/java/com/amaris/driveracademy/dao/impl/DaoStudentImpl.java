/*
 * @(#)DaoStudentImpl.java
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

import com.amaris.driveracademy.dao.DaoStudent;
import com.amaris.driveracademy.entities.Students;
import com.amaris.driveracademy.entities.projections.InformationStudentProjection;
import com.amaris.driveracademy.enums.CommonError;
import com.amaris.driveracademy.enums.DriverAcademyError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.repositories.ModuleRepository;
import com.amaris.driveracademy.repositories.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

/**
 * DaoStudentImpl.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@Repository
@RequiredArgsConstructor
public class DaoStudentImpl implements DaoStudent {

    /** studentRepository. */
    private final StudentRepository studentRepository;
    /** moduleRepository. */
    private final ModuleRepository moduleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Students insertStudent(final Students students) {
        try {
            return this.studentRepository.save(students);
        }
        catch (final DataIntegrityViolationException integrityViolationException) {
            throw new SimpleException(DriverAcademyError.ERROR_STUDENT_EXIST,
                HttpStatus.BAD_REQUEST.value(), integrityViolationException);
        }catch (final Exception ex) {
            throw new SimpleException(CommonError.INTERMITTENT_SERVICE, HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Students> getAllStudents() {
        try {
            return this.studentRepository.findAll();
        }catch (final Exception ex) {
            throw new SimpleException(CommonError.INTERMITTENT_SERVICE, HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<InformationStudentProjection> getDetailStudent(long id) {
        try {
            final var studentDetail = this.studentRepository.findDetailStudent(id);
            if(studentDetail.isEmpty()) {
                throw new SimpleException(DriverAcademyError.ERROR_EMPTY_STUDENTS, HttpStatus.NO_CONTENT.value());
            }
            return studentDetail;
        }catch (final DataIntegrityViolationException integrityViolationException) {
            throw new SimpleException(DriverAcademyError.ERROR_STUDENT_EXIST,
                HttpStatus.BAD_REQUEST.value(), integrityViolationException);
        }catch (final Exception ex) {
            throw new SimpleException(CommonError.INTERMITTENT_SERVICE, HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

}