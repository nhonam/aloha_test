package com.aloha.examtest.service;

import com.aloha.examtest.dto.response.ExamTurnDTO;
import com.aloha.examtest.dto.response.RankDTO;
import com.aloha.examtest.dto.response.RegistrationsDTO;
import com.aloha.examtest.dto.response.TopRankUser;
import com.aloha.examtest.repository.QuizFilterItemsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) // các field sẽ là private final
@Slf4j
public class UserService {

    QuizFilterItemsRepository quizFilterItemsRepository;


    //    @PreAuthorize("hasRole('ADMIN')") // nếu như dùng PostAuthorize thì cũng như vậy nhưng mà method sẽ vẫn được
    // chạy ngược lại PreAuthorize thì không
    public List<RankDTO> getUsers() {
        log.info("In methodgetUsers");
        return quizFilterItemsRepository.get_user_dto();
    }


    public List<TopRankUser> topRankUserNpage() {
        log.info("In method get topRankUser");
        return quizFilterItemsRepository.topRankUser( );
    }

    public List<RegistrationsDTO> getRegistrations() {
        log.info("In method get topRankUser");
        return quizFilterItemsRepository.getRegistrations( );
    }

    public List<ExamTurnDTO> getExamTurn() {
        log.info("In method get topRankUser");
        return quizFilterItemsRepository.getExamTurn( );
    }

    public Page<TopRankUser> getTopRankUsers(Pageable pageable) {
        List<TopRankUser> allUsers = quizFilterItemsRepository.topRankUser();

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), allUsers.size());

        List<TopRankUser> pagedUsers = allUsers.subList(start, end);

        return new PageImpl<>(pagedUsers, pageable, allUsers.size());
    }


    public List<TopRankUser> topRankUser() {
        log.info("In method get topRankUser");
        return quizFilterItemsRepository.topRankUser( );
    }


}
