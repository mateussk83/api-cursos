package com.rocketseat.cursosspring.modules.course.controllers;

import com.rocketseat.cursosspring.modules.course.CourseEntity;
import com.rocketseat.cursosspring.modules.course.dto.CreateCourseRequestDTO;
import com.rocketseat.cursosspring.modules.course.useCase.CourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseUseCase courseUseCase;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody CreateCourseRequestDTO createCourseRequestDTO) {
        try {
            var result = this.courseUseCase.create(createCourseRequestDTO);
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

