/*
 * @(#)LicenseServiceImpl.java
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

import com.amaris.driveracademy.dao.DaoLicense;
import com.amaris.driveracademy.dtos.response.LicensesResponseDTO;
import com.amaris.driveracademy.enums.DriverAcademyError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.amaris.driveracademy.services.LicenseService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * LicenseServiceImpl.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    /** modelMapper. */
    private final ModelMapper modelMapper;
    /** daoLicense. */
    private final DaoLicense daoLicense;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LicensesResponseDTO> getAllLicenses() {
        final var licenses = this.daoLicense.getAllLicenses();
        final var licensesMapper = new ArrayList<LicensesResponseDTO>();
        if(licenses.isEmpty()) {
            throw new SimpleException(DriverAcademyError.ERROR_EMPTY_MODULE, HttpStatus.NO_CONTENT.value());
        }
        licenses.forEach(license -> licensesMapper.add(this.modelMapper.map(license, LicensesResponseDTO.class)));
        return licensesMapper;
    }

}