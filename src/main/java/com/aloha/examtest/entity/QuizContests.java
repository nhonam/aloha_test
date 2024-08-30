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
@Table(name = "quiz_contests")
public class QuizContests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long contest_id;

    int deleted;

    @CreationTimestamp
    LocalDateTime created_at;

    @UpdateTimestamp
    LocalDateTime updated_at;

    @Column(length = 200)
    String title;

    @Column(length = 200)
    String slug;

    @Column(length = 400)
    String image;

    @Column(length = 6)
    String code;


    long user_id;
    int status;

    @Column(length = 500)
    String contest_bg;

    @Column(columnDefinition = "TEXT")
    String contest_description;

    LocalDateTime contest_start;

    LocalDateTime contest_end;

    @Column(columnDefinition = "TEXT")
    String timeline;
    @Column(columnDefinition = "TEXT")
    String contest_org1;

    @Column(columnDefinition = "TEXT")
    String contest_org2;

    @Column(columnDefinition = "TEXT")
    String contest_navigation;

    long contest_filter_id;

    int theme;

    @Column(length = 30)
    String theme_color;

    int sticker;


    @Column(length = 400)
    String contest_url_guide;

    @Column(length = 255)
    String contest_org_name;

    @Column(length = 255)
    String contest_org_address;

    @Column(length = 255)
    String contest_org_email;

    @Column(length = 255)
    String contest_org_tel;

    long quiz_id;

    @Column(columnDefinition = "TEXT")
    String email_permission;

    @Column(length = 30)
    String password;

    @Column(columnDefinition = "TEXT")
    String register_required_settings;

    int contest_require_reg_form;

    boolean contest_show_register;

    boolean contest_show_done;
    boolean contest_show_top;

    @Column(columnDefinition = "TEXT")
    String statistic;

    @Column(length = 20)
    String source_type;

    @Column(length = 10)
    String sharing_code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenants tenant;




}
