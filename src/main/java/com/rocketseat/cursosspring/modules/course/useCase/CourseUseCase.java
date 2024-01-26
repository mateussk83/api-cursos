package com.rocketseat.cursosspring.modules.course.useCase;

import com.rocketseat.cursosspring.exceptions.CourseFoundException;
import com.rocketseat.cursosspring.modules.course.CourseEntity;
import com.rocketseat.cursosspring.modules.course.CourseRepository;
import com.rocketseat.cursosspring.modules.course.dto.CreateCourseRequestDTO;
import com.rocketseat.cursosspring.modules.course.dto.CreateCourseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CreateCourseResponseDTO create(CreateCourseRequestDTO createCourseRequestDTO) {

            this.courseRepository.findByName(createCourseRequestDTO.getName())
                .ifPresent((course) -> {
                    throw new CourseFoundException();
                });

            var course = CourseEntity.builder()
                .active(true)
                .name(createCourseRequestDTO.getName())
                .category(createCourseRequestDTO.getCategory())
                .build();

            this.courseRepository.save(course);

            return CreateCourseResponseDTO.builder()
                    .id(course.getId())
                    .category(course.getCategory())
                    .active(true)
                    .name(course.getName())
                    .build();



    }
}
