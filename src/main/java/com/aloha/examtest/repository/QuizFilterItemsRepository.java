package com.aloha.examtest.repository;

import com.aloha.examtest.dto.response.ExamTurnDTO;
import com.aloha.examtest.dto.response.RankDTO;
import com.aloha.examtest.dto.response.RegistrationsDTO;
import com.aloha.examtest.dto.response.TopRankUser;
import com.aloha.examtest.entity.QuizFilterItems;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuizFilterItemsRepository extends PagingAndSortingRepository<QuizFilterItems, Long> {

    @Query(value = "call get_user_dto()", nativeQuery = true)
    List<RankDTO> get_user_dto();

    @Query(value = "call top_rank_user()", nativeQuery = true)
    List<TopRankUser> topRankUser();

    @Query(value = "call get_registrations()", nativeQuery = true)
    List<RegistrationsDTO> getRegistrations();

    @Query(value = "call get_examturn()", nativeQuery = true)
    List<ExamTurnDTO> getExamTurn();

}
