package com.example.cqrswrite.domain.feed.persistence.entity;

import com.example.cqrswrite.common.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@SuperBuilder
@NoArgsConstructor
@Table(name = "tbl_feed")
@Entity
public class FeedEntity extends BaseTimeEntity {

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(500)")
    private String content;
}
