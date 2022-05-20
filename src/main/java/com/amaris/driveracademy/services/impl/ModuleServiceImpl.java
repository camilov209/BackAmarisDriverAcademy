/*
 * @(#)ModuleServiceImpl.java
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

import com.amaris.driveracademy.dao.DaoModule;
import com.amaris.driveracademy.dtos.response.ModulesResponseDTO;
import com.amaris.driveracademy.enums.DriverAcademyError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.services.ModuleService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * ModuleServiceImpl.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    /** modelMapper. */
    private final ModelMapper modelMapper;
    /** daoModule. */
    private final DaoModule daoModule;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ModulesResponseDTO> getAllModules() {
        final var modules = this.daoModule.getAllModules();
        final var modulesMapper = new ArrayList<ModulesResponseDTO>();
        if(modules.isEmpty()) {
            throw new SimpleException(DriverAcademyError.ERROR_EMPTY_MODULE, HttpStatus.NO_CONTENT.value());
        }
        modules.forEach(module -> modulesMapper.add(this.modelMapper.map(module, ModulesResponseDTO.class)));
        return modulesMapper;
    }

}