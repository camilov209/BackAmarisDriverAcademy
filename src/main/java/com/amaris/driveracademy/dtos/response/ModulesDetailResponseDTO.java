/*
 * @(#)ModulesDetailResponseDTO.java
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
package com.amaris.driveracademy.dtos.response;

import com.amaris.driveracademy.entities.Courses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ModulesDetailResponseDTO.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 21-05-2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModulesDetailResponseDTO {
    /** moduleId. */
    private Long moduleId;
    /** moduleName. */
    private String moduleName;
    /** courses. */
    private Courses courses;
}