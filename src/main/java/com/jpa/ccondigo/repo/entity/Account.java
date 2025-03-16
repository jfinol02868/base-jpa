package com.jpa.ccondigo.repo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@IdClass(AccountId.class)
public class Account {

    @Id
    private String accountNumber;

    @Id
    private String accountType;

    private String name;
    private String accountName;

}
