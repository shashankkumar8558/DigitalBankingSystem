package io.github.shashankkumar8558.dto;

import io.github.shashankkumar8558.entity.AccountStatus;
import io.github.shashankkumar8558.entity.AccountType;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class accountResponse {

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
