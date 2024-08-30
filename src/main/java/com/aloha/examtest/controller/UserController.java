package com.aloha.examtest.controller;


import com.aloha.examtest.dto.ApiResponse;
import com.aloha.examtest.dto.response.ExamTurnDTO;
import com.aloha.examtest.dto.response.RegistrationsDTO;
import com.aloha.examtest.dto.response.TopRankUser;
import com.aloha.examtest.exception.SuccessCode;
import com.aloha.examtest.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) // các field sẽ là private final
@Slf4j
public class UserController {

    UserService userService;


    @GetMapping("/rank-npage")
    ApiResponse<List<TopRankUser>> getTopRankUserNotPage() {

        return ApiResponse.<List<TopRankUser>>builder()
                .code(SuccessCode.GET_SUCCESS.getCode())
                .result(userService.topRankUserNpage())
                .message(SuccessCode.GET_SUCCESS.getMessage())
                .build();
    }


    @GetMapping("/registrations")
    ApiResponse<List<RegistrationsDTO>> getTopRankRegistrations() {

        return ApiResponse.<List<RegistrationsDTO>>builder()
                .code(SuccessCode.GET_SUCCESS.getCode())
                .result(userService.getRegistrations())
                .message(SuccessCode.GET_SUCCESS.getMessage())
                .build();
    }


    @GetMapping("/exam-turn")
    ApiResponse<List<ExamTurnDTO>> getTopRankExamTurn() {

        return ApiResponse.<List<ExamTurnDTO>>builder()
                .code(SuccessCode.GET_SUCCESS.getCode())
                .result(userService.getExamTurn())
                .message(SuccessCode.GET_SUCCESS.getMessage())
                .build();
    }

    @GetMapping("/rank")
    ApiResponse<Page<TopRankUser>> getTopRankUser( @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size) {
        return ApiResponse.<Page<TopRankUser>>builder()
                .code(SuccessCode.GET_SUCCESS.getCode())
                .result(userService.getTopRankUsers(PageRequest.of(page, size)))
                .message(SuccessCode.GET_SUCCESS.getMessage())
                .build();
    }


}
