package com.rohith.DTOexample.DTO;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private String name;
    private LocalDate dob;
    private String email;
}
