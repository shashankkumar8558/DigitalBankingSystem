package io.github.shashankkumar8558.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class createAccountRequest {

  @NotBlank(message = "Account holder name is required")
  private String accountHolderName;

  @NotBlank(message = "Email is required")
  @Email(message = "Invalid email format")
  private String email;

  @NotBlank(message = "Phone is required")
  private String phone;

  @NotNull(message = "Account type is required")
  private AccountType accountType;

  @NotNull(message = "Initial deposit is required")
  @Positive(message = "Initial deposit must be positive")
  private BigDecimal initialDeposit;

}
