package com.example.demo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateStudentRequest {

    @Schema(description = "Student name", example = "Wang xiao ming")
    private String name;
    private String password;

    @Schema(description = "exam score need between 0 to 100.", example = "85")
    private Integer score;
}
