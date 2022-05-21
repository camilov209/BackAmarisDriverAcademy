/*
 * @(#)CourseRepository.java
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

import com.amaris.driveracademy.entities.Courses;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * CourseRepository.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 21-05-2022
 */
public interface CourseRepository extends JpaRepository<Courses, Long> {

    /**
     * Obtiene cursos relacionados con los módulos.
     *
     * @param pCourseId {@link Long}
     * @param pModuleId {@link Long}
     * @return {@link Courses}
     */
    @Query("SELECT c " +
        "FROM Courses c WHERE c.courseId IN :pCourseId AND c.modules.moduleId IN :pModuleId")
    List<Courses> getCoursesByIdAndModuleId(List<Long> pCourseId, List<Long> pModuleId);
}