package com.rocketseat.cursosspring.modules.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseResponseDTO {

    private UUID id;
    private String name;
    private String category;
    private boolean active;
}
