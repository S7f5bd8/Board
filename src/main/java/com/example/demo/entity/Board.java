package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Board extends BaseEntity {
    @Id //기본키(primary key) 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 자동 증가
    private Long bno;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer; //Foreign Key 설정(참조무결성 유지)
}
