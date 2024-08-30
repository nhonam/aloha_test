package com.aloha.examtest.dto.request;

import com.aloha.examtest.validator.DobContraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuizResultResponse {
    String password;
    String firstName;
    String lastName;

    @DobContraint(min = 18, message = "INVALID_BOD")
    LocalDate dob;

    Set<String> roles;
}
