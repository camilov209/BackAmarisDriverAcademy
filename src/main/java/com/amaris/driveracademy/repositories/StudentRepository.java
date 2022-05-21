/*
 * @(#)StudentRepository.java
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
package com.amaris.driveracademy.repositories;

import com.amaris.driveracademy.entities.Students;
import com.amaris.driveracademy.entities.projections.InformationStudentProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * StudentRepository.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
public interface StudentRepository extends JpaRepository<Students, Long> {

    /**
     * Obtiene el detalle del estudiante con los cursos.
     *
     * @param pStudentId {@link Long}
     * @return {@link InformationStudentProjection}
     */
    @Query("SELECT s.studentId as studentId, s.studentName as studentName, s.studentAge as studentAge, " +
        "s.studentIdentification as studentIdentification, " +
        "m.moduleName as moduleName, c.courseName as courseName " +
        "FROM Students s " +
        "LEFT JOIN InscriptionCourses ic " +
        "ON s.studentId = ic.students.studentId " +
        "LEFT JOIN Modules m " +
        "ON m.moduleId = ic.modules.moduleId " +
        "LEFT JOIN Courses c " +
        "ON c.courseId = ic.courses.courseId " +
        "WHERE s.studentId = :pStudentId")
    List<InformationStudentProjection> findDetailStudent(long pStudentId);

}