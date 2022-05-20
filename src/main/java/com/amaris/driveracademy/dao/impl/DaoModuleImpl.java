/*
 * @(#)DaoModuleImpl.java
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

import com.amaris.driveracademy.dao.DaoModule;
import com.amaris.driveracademy.entities.Modules;
import com.amaris.driveracademy.enums.CommonError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.repositories.ModuleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

/**
 * DaoModuleImpl.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@Repository
@RequiredArgsConstructor
public class DaoModuleImpl implements DaoModule {

    /** moduleRepository. */
    private final ModuleRepository moduleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Modules> getAllModules() {
        try {
            return this.moduleRepository.findAll();
        }catch (final Exception ex) {
            throw new SimpleException(CommonError.INTERMITTENT_SERVICE, HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

}