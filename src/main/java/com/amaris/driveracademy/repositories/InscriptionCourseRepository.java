/*
 * @(#)InscriptionCourseRepository.java
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

import com.amaris.driveracademy.entities.InscriptionCourses;
import com.amaris.driveracademy.entities.Students;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * InscriptionCourseRepository.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 20-05-2022
 */
public interface InscriptionCourseRepository extends JpaRepository<InscriptionCourses, Long> {

    /**
     * Obtiene modulos registrados.
     *
     * @param pModuleId {@link Long}
     * @return {@link InscriptionCourses}
     */
    @Query("SELECT ic FROM InscriptionCourses ic " +
        "WHERE ic.students.studentId IN :pStudentId AND ic.modules.moduleId IN :pModuleId")
    List<InscriptionCourses> findByModuleIdAndStudentId(List<Long> pStudentId, List<Long> pModuleId);
}