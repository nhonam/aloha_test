package com.aloha.examtest.repository;

import com.aloha.examtest.entity.QuizFilters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizFiltersRepository extends JpaRepository<QuizFilters, Long> {}
