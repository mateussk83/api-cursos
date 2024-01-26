package com.rocketseat.cursosspring.modules.course.controllers;

import com.rocketseat.cursosspring.modules.course.dto.CourseRequestDTO;
import com.rocketseat.cursosspring.modules.course.useCase.CourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{id}/inativar")
    public ResponseEntity inactivate(@PathVariable UUID id) {
        try {
            var result = this.courseUseCase.inactivate(id);
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}/ativar")
    public ResponseEntity active(@PathVariable UUID id) {
        try {
            var result = this.courseUseCase.active(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity delete(@PathVariable UUID id) {
        try {
            this.courseUseCase.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity select(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        try {
            var result = this.courseUseCase.select(courseRequestDTO);
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

