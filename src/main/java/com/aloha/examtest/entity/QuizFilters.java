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
@Table(name = "quiz_filters")
public class QuizFilters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long filter_id;

    @CreationTimestamp
    LocalDateTime created_at;

    @UpdateTimestamp
    LocalDateTime updated_at;

    LocalDateTime deleted_at;

    int deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenants tenant;

    @Column(length = 400)
    String filter_description;

    @Column(length = 400)
    String filter_name;
    long user_id;
    

}
