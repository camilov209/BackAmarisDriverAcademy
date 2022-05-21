/*
 * @(#)LicenseTypeController.java
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
package com.amaris.driveracademy.controllers;

import com.amaris.driveracademy.dtos.response.LicensesResponseDTO;
import com.amaris.driveracademy.services.LicenseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LicenseTypeController.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "license", produces = MediaType.APPLICATION_JSON_VALUE)
public class LicenseController {

    /** licenseService. */
    private final LicenseService licenseService;

    /**
     * Servicio que obtiene todos los tipos de licencia.
     *
     * @return {@link LicensesResponseDTO}
     */
    @GetMapping
    public List<LicensesResponseDTO> getAllLicenses() {
        return this.licenseService.getAllLicenses();
    }
}