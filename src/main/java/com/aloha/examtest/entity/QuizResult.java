package com.aloha.examtest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
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
@Table(name = "quiz_result")
public class QuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long result_id;

    int deleted;

    long user_id;

    long quiz_id;

    @CreationTimestamp
    LocalDateTime created_at;

    @UpdateTimestamp
    LocalDateTime updated_at;

    float question_total;

    float answer_acc;
    float percent;
    int seconds;
    long source_id;
    long filter_id;
    long item_id;
    long item2_id;

    @Column(length = 30)
    String tel;

    @Column(length = 400)
    String item_description;

    @Column(length = 255)
    String item_description_2;

    @Column(length = 255)
    String contestant_name;

    double score;

    @Column(columnDefinition = "TEXT")
    String comment;
    @Column(length = 20)
    String source_type;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenants tenant;

    @Column(length = 400)
    boolean fraud_warning;

    @Column(columnDefinition = "JSON")
    String time_record;

    

}
