package com.rocketseat.cursosspring.exceptions;

public class CourseFoundException extends RuntimeException {

    public CourseFoundException() {
        super("Curso já existente");
    }
}
