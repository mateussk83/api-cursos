package com.rocketseat.cursosspring.modules.course.useCase;

import com.rocketseat.cursosspring.exceptions.CourseFoundException;
import com.rocketseat.cursosspring.modules.course.CourseEntity;
import com.rocketseat.cursosspring.modules.course.CourseRepository;
import com.rocketseat.cursosspring.modules.course.dto.CourseRequestDTO;
import com.rocketseat.cursosspring.modules.course.dto.CourseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class CourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseResponseDTO create(CourseRequestDTO courseRequestDTO) {

            this.courseRepository.findByName(courseRequestDTO.getName())
                .ifPresent((course) -> {
                    throw new CourseFoundException();
                });

            var course = CourseEntity.builder()
                .active(true)
                .name(courseRequestDTO.getName())
                .category(courseRequestDTO.getCategory())
                .build();

            this.courseRepository.save(course);

            return CourseResponseDTO.builder()
                    .id(course.getId())
                    .category(course.getCategory())
                    .active(true)
                    .name(course.getName())
                    .build();
    }

    public CourseResponseDTO update(UUID id, CourseRequestDTO courseRequestDTO) {

        var course = this.courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new CourseFoundException("Curso Não Encontrado");
                });

        course.setName(courseRequestDTO.getName());
        course.setCategory(courseRequestDTO.getCategory());

        this.courseRepository.save(course);

        return CourseResponseDTO.builder()
                .id(course.getId())
                .category(course.getCategory())
                .active(true)
                .name(course.getName())
                .build();
    }
}
