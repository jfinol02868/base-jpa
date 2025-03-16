package com.jpa.ccondigo.repo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountId implements Serializable {

    private String accountNumber;
    private String accountType;

}
