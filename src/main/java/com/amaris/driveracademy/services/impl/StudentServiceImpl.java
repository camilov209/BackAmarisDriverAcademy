/*
 * @(#)StudentServiceImpl.java
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

import com.amaris.driveracademy.dao.DaoStudent;
import com.amaris.driveracademy.dtos.request.StudentRequestDTO;
import com.amaris.driveracademy.dtos.response.ModulesDetailResponseDTO;
import com.amaris.driveracademy.dtos.response.StudentDetailResponseDTO;
import com.amaris.driveracademy.dtos.response.StudentsResponseDTO;
import com.amaris.driveracademy.entities.Courses;
import com.amaris.driveracademy.entities.Licenses;
import com.amaris.driveracademy.entities.Modules;
import com.amaris.driveracademy.entities.Students;
import com.amaris.driveracademy.enums.DriverAcademyError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.services.StudentService;
import com.amaris.driveracademy.validations.StudentValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * StudentServiceImpl.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    /** modelMapper. */
    private final ModelMapper modelMapper;
    /** daoStudent. */
    private final DaoStudent daoStudent;
    /** studentValidation. */
    private final StudentValidation studentValidation;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> insertStudent(final StudentRequestDTO studentRequest) {
        if(studentValidation.validateRequiredFieldsStudent(studentRequest)) {
            throw new SimpleException(DriverAcademyError.ERROR_REQUIRED_FIELDS, HttpStatus.BAD_REQUEST.value());
        }
        final var student = this.modelMapper.map(studentRequest, Students.class);
        this.daoStudent.insertStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<StudentsResponseDTO> getAllStudents() {
        final var students = this.daoStudent.getAllStudents();
        final var studentsMapper = new ArrayList<StudentsResponseDTO>();
        if(students.isEmpty()) {
            throw new SimpleException(DriverAcademyError.ERROR_STUDENT_EXIST, HttpStatus.NO_CONTENT.value());
        }
        students.forEach(student -> studentsMapper.add(this.modelMapper.map(student, StudentsResponseDTO.class)));
        return studentsMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentDetailResponseDTO getDetailStudent(long id) {
        final var studentMapper = new StudentDetailResponseDTO();
        final var modulesMapper = new ArrayList<ModulesDetailResponseDTO>();
        final var license = new Licenses();
        final var studentDetail = this.daoStudent.getDetailStudent(id);
        studentMapper.setStudentId(studentDetail.get(0).getStudentId());
        studentMapper.setStudentName(studentDetail.get(0).getStudentName());
        studentMapper.setStudentAge(studentDetail.get(0).getStudentAge());
        studentMapper.setStudentIdentification(studentDetail.get(0).getStudentIdentification());
        license.setLicenseId(studentDetail.get(0).getLicenseId());
        license.setLicenseName(studentDetail.get(0).getLicenseName());
        studentMapper.setLicense(license);
        studentDetail.forEach(detail -> {
            final var module = new ModulesDetailResponseDTO();
            final var course = new Courses();
            if(!Objects.isNull(detail.getModuleId())) {
                module.setModuleId(detail.getModuleId());
                module.setModuleName(detail.getModuleName());
                course.setCourseId(detail.getCourseId());
                course.setCourseName(detail.getCourseName());
                module.setCourses(course);
                modulesMapper.add(module);
            }
        });
        studentMapper.setModule(modulesMapper);
        return studentMapper;
    }

}