package com.example.cqrswrite.domain.user.persistence.entity;

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
@Table(name = "tbl_user")
@Entity
public class UserEntity extends BaseTimeEntity {

    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String accountId;

    @Column(columnDefinition = "CHAR(60)", nullable = false)
    private String password;
}
