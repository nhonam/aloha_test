package com.aloha.examtest.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuizResultCreationRequest {

    @Size(min = 3, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;

    String firstName;
    String lastName;

//    @DobContraint(min = 18, message = "INVALID_BOD")
//    LocalDate dob;
}
