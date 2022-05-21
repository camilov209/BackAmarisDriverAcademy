/*
 * @(#)CustomExceptionHandler.java
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
package com.amaris.driveracademy.config;

import com.amaris.driveracademy.enums.CommonError;
import com.amaris.driveracademy.exceptions.SimpleException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * CustomExceptionHandler.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 19-05-2022
 */
@NoArgsConstructor
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    /** SIMPLE_EXCEPTION. */
    private static final String SIMPLE_EXCEPTION = "com.amaris.driveracademy.exceptions.SimpleException";
    /** mapper. */
    private final ObjectMapper mapper = new ObjectMapper();

    // -------------------------------------------------------------------
    // -- Métodos Sobrescritos -------------------------------------------
    // -------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        final MethodArgumentNotValidException ex,
        final HttpHeaders headers, final HttpStatus status,
        final WebRequest request) {
        return this.handleExceptionInternal(ex, new SimpleException(CommonError.INVALID_ARGS), headers, status,
            request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
        final HttpRequestMethodNotSupportedException ex,
        final HttpHeaders headers,
        final HttpStatus status,
        final WebRequest request) {
        return this.handleExceptionInternal(ex, new SimpleException(CommonError.NOT_ALLOWED), headers, status,
            request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(
        final ServletRequestBindingException ex,
        final HttpHeaders headers,
        final HttpStatus status,
        final WebRequest request) {
        return this.handleExceptionInternal(ex, new SimpleException(CommonError.NOT_ALLOWED), headers, status, request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
        final HttpMessageNotReadableException ex,
        final HttpHeaders headers, final HttpStatus status,
        final WebRequest request) {
        return this.handleExceptionInternal(ex, new SimpleException(CommonError.INVALID_BODY), headers, status,
            request);
    }

    // -------------------------------------------------------------------
    // -- Métodos Públicos -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Manejo de errores controlados: Tipo de todas la excepciones controladas de la aplicacion.
     *
     * @param ex {@link SimpleException} excepcion a controlar
     * @param webRequest {@link WebRequest} info del request
     * @return {@link ResponseEntity} respuesta en formato JSON de la aplicacion.
     */
    @ExceptionHandler(SimpleException.class)
    public ResponseEntity<Object> handleSimpleException(final SimpleException ex, final WebRequest webRequest) {
        return this.doHandleSimpleException(ex, webRequest);
    }

    /**
     * Manejo de las SimpleException
     *
     * @param ex {@link SimpleException} excepcion a controlar
     * @param webRequest webRequest {@link WebRequest} info del request
     * @return {@link ResponseEntity} respuesta en formato JSON de la aplicacion.
     */
    private ResponseEntity<Object> doHandleSimpleException(final SimpleException ex, final WebRequest webRequest) {
        if (ex.getCause() != null) {
            if(CustomExceptionHandler.isCauseType(ex, SimpleException.class)) {
                return this.handleSimpleException((SimpleException) ex.getCause(), webRequest);
            }
        }
        return this.handleExceptionInternal(ex, ex, new HttpHeaders(), HttpStatus.valueOf(ex.getStatus()), webRequest);
    }

    /**
     * Manejo de errores NO controlados: Exception General.
     *
     * @param ex excepcion a controlar
     * @param webRequest info del request
     * @return {@link ResponseEntity} respuesta en formato JSON de la aplicacion.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(final Exception ex, final WebRequest webRequest) {
        return this.handleExceptionInternal(ex, new SimpleException(CommonError.DEFAULT), new HttpHeaders(),
            HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }

    // -------------------------------------------------------------------
    // -- Métodos Protected ----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Manejo de errores NO controlados: Tipo de argumento en un controller no
     * correspondiente.
     *
     * @param ex excepcion a controlar
     * @param request info del request
     * @return {@link ResponseEntity} respuesta en formato JSON de la aplicacion.
     */
    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    protected ResponseEntity<Object> handleInvalidRequest(final MethodArgumentTypeMismatchException ex,
        final WebRequest request) {
        return this.handleExceptionInternal(ex, new SimpleException(CommonError.INVALID_ARGS), new HttpHeaders(),
            HttpStatus.BAD_REQUEST, request);
    }

    // -------------------------------------------------------------------
    // -- Métodos Privados -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Valida si la exception causa pertenece a un tipo en particular.
     *
     * @param e excepcion
     * @param type si es un tipo de esas excepciones.
     * @return <code>true</code> si la excepcion es del <code>type</code>,
     *         <code>false</code> en otra condicion.
     */
    private static boolean isCauseType(final Exception e, final Class<?> type) {
        return type.isAssignableFrom(e.getCause().getClass());
    }
}