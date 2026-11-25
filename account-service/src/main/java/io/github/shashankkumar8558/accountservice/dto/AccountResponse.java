package io.github.shashankkumar8558.accountservice.dto;

import java.time.LocalDateTime;

import io.github.shashankkumar8558.accountservice.entity.AccountStatus;
import io.github.shashankkumar8558.accountservice.entity.AccountType;

import java.math.BigDecimal;

public class AccountResponse {

  private String id;

  private String accountNumber;

  private String accountHolderName;

  private String email;

  private String phone;

  private AccountType accountType;

  private AccountStatus status;

  private BigDecimal balance;

  private BigDecimal dailyTransactionLimit;

  private LocalDateTime createAt;

}
