/*
 * @(#)Students.java
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Students.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "STUDENTS")
public class Students {
    /** Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long studentId;
    /** Student Name. */
    @Column(name = "NAME")
    private String studentName;
    /** Student Age. */
    @Column(name = "AGE")
    private String studentAge;
    /** Student Identification. */
    @Column(name = "IDENTIFICATION")
    private String studentIdentification;
    /** licenses. */
    @ManyToMany(cascade = { CascadeType.MERGE})
    @JoinTable(name = "LICENSES_REGISTRATION",
        joinColumns = @JoinColumn(name = "ID_STUDENT", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ID_LICENSE", referencedColumnName = "id"))
    private List<Licenses> licenses;

}