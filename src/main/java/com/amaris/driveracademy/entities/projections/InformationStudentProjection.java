/*
 * @(#)InformationStudentProjection.java
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
package com.amaris.driveracademy.entities.projections;

import com.amaris.driveracademy.entities.Modules;
import java.util.List;

/**
 * InformationStudentProjection.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 20-05-2022
 */
public interface InformationStudentProjection {

    /** studentId. */
    Long getStudentId();
    /** studentName. */
    String getStudentName();
    /** studentAge. */
    String getStudentAge();
    /** studentIdentification. */
    String getStudentIdentification();
    /** moduleId. */
    Long getModuleId();
    /** moduleName. */
    String getModuleName();
    /** courseId. */
    Long getCourseId();
    /** courseName. */
    String getCourseName();
    /** licenseId. */
    Long getLicenseId();
    /** licenseName. */
    String getLicenseName();
}