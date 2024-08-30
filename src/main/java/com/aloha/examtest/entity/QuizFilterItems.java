package com.aloha.examtest.entity;

import com.aloha.examtest.validator.DobContraint;
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
@Table(name = "quiz_filter_items")
public class QuizFilterItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long item_id;

    @CreationTimestamp
    LocalDateTime created_at;

    @UpdateTimestamp
    LocalDateTime updated_at;


    LocalDateTime deleted_at;


    long filter_id;

    @Column(length = 300)
    String item_name;
    long parent_id;


}
