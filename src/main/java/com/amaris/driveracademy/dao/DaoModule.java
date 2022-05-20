/*
 * @(#)DaoModule.java
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

import com.amaris.driveracademy.entities.Modules;
import java.util.List;

/**
 * DaoModule.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
public interface DaoModule {

    /**
     * Obtiene todos los modulos y cursos de bd.
     *
     * @return {@link Modules}
     */
    List<Modules> getAllModules();
}