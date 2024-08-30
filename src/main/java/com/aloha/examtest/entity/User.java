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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long user_id;

    @Column(name = "deleted")
    int deleted;

    @Column(length = 200, unique = true)
    String username;

    @Column(length = 250)
    String password;
    String remember_token;

    @Column(unique = true)
    String email;
    String email_display;
    String name;

    @Column(length = 300)
    String avatar;
    int gender;

    @Column(length = 20)
    String identity_card;

    @DobContraint(min=18)
    LocalDateTime birthday;
    String tel1;
    String tel2;

    @Column(columnDefinition = "TEXT")
    String description;
    int labor_federation_group_id;
    int user_group_id;
    int is_root;
    @CreationTimestamp
    LocalDateTime created_at;

    @UpdateTimestamp
    LocalDateTime updated_at;
    int user_type;
    int contest_permission;
    int activation;

    @Column(length = 191)
    String activation_code;
    String job;
    boolean submit_contest;
    String apple;
    String firebase_uid;
    boolean verified;

    @Column(unique = true)
    long myaloha_user_id;

}
