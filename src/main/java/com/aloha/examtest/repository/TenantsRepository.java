package com.aloha.examtest.repository;

import com.aloha.examtest.entity.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantsRepository extends JpaRepository<Tenants, Long> {}
