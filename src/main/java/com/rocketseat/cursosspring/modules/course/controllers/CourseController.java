package com.rocketseat.cursosspring.modules.course.controllers;

import com.rocketseat.cursosspring.modules.course.dto.CourseRequestDTO;
import com.rocketseat.cursosspring.modules.course.useCase.CourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseUseCase courseUseCase;

    @PostMapping("/")
    public ResponseEntity create(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        try {
            var result = this.courseUseCase.create(courseRequestDTO);
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody CourseRequestDTO courseRequestDTO) {
        try {
            var result = this.courseUseCase.update(id, courseRequestDTO);
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

