/*
 * @(#)DaoStudent.java
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

import com.amaris.driveracademy.entities.Students;
import java.util.List;

/**
 * DaoStudent.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
public interface DaoStudent {

    /**
     * Inserta estudante en db.
     *
     * @param students {@link Students}
     * @return {@link Students}
     */
    Students insertStudent(Students students);

    /**
     * Obtiene todos los estudiantes en bd.
     *
     * @return {@link Students}
     */
    List<Students> getAllStudents();

    /**
     * Obtiene el detalle del estudiante.
     *
     * @return {@link Students}
     */
    Students getDetailStudent(long id);
}