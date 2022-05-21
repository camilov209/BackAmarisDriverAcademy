/*
 * @(#)DaoInscriptionCourse.java
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
package com.amaris.driveracademy.dao;

import com.amaris.driveracademy.entities.InscriptionCourses;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * DaoInscriptionCourse.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 20-05-2022
 */
public interface DaoInscriptionCourse {

    /**
     * Inserta modulos y cursos en bd.
     *
     * @param inscriptionCourses {@link InscriptionCourses}
     * @return {@link InscriptionCourses}
     */
    List<InscriptionCourses> insertInscriptionCourse(List<InscriptionCourses> inscriptionCourses);
}