package com.rohith.jpaMapping.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentDTO {
    private String studentName;
    private List<Long> courseIds;
}
