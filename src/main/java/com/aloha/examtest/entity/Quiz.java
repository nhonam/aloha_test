package com.aloha.examtest.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long quiz_id;

    int deleted;

    long user_id;
    long category_id;

    @CreationTimestamp
    LocalDateTime created_at;

    @UpdateTimestamp
    LocalDateTime updated_at;

    @Column(length = 100)
    String title;

    @Column(length = 200)
    String slug;

    @Column(columnDefinition = "TEXT")
    String image;

    @Column(columnDefinition = "LONGTEXT")
    String essay;

    int status;

    long price;

    int sold;

    LocalDateTime listed_at;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenants tenant;




}
