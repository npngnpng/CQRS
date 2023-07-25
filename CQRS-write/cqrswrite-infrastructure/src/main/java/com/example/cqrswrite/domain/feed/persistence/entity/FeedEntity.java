package com.example.cqrswrite.domain.feed.persistence.entity;

import com.example.cqrswrite.common.entity.BaseTimeEntity;
import com.example.cqrswrite.domain.user.persistence.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@SuperBuilder
@DynamicInsert
@NoArgsConstructor
@Table(name = "tbl_feed")
@Entity
public class FeedEntity extends BaseTimeEntity {

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(500)")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
}
