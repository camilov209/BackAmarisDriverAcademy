/*
 * @(#)StudentsResponseDTO.java
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

import com.amaris.driveracademy.entities.Licenses;
import com.amaris.driveracademy.entities.Modules;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StudentsResponseDTO.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentsResponseDTO {
    /** studentId. */
    private Long studentId;
    /** name. */
    private String studentName;
    /** age. */
    private String studentAge;
    /** identification. */
    private String studentIdentification;
    /** license. */
    private Licenses license;
}