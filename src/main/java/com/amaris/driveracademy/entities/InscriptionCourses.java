/*
 * @(#)InscriptionCourses.java
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
package com.amaris.driveracademy.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * InscriptionCourses.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 20-05-2022
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "INSCRIPTION_COURSES")
public class InscriptionCourses {
    /** Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INSCRIPTION_ID")
    private Long inscriptionId;
    /** students. */
    @ManyToOne
    @JoinColumn(name = "ID_STUDENT")
    private Students students;
    /** students. */
    @ManyToOne
    @JoinColumn(name = "ID_MODULE")
    private Modules modules;
    /** students. */
    @ManyToOne
    @JoinColumn(name = "ID_COURSE")
    private Courses courses;
}