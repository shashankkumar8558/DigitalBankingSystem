package io.github.shashankkumar8558.accountservice.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.shashankkumar8558.accountservice.dto.AccountResponse;
import io.github.shashankkumar8558.accountservice.dto.CreateAccountRequest;
import io.github.shashankkumar8558.accountservice.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  // we will create endPoints for 1) creating an Account
  // 2) getAccount
  // 3) getBalance
  // 4) blockAccount

  // SAGA step 1) deduct balance
  // 2) credit balance --> credit Reciever and credit Sender(refund) --> this is
  // SAGA step 4.

  @PostMapping
  public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request) {

    return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(request));

  }

  @GetMapping("/{accountNumber}")
  public ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumber) {
    return ResponseEntity.ok(accountService.getAccount(accountNumber));
  }

  @GetMapping("/{accountNumber}/balance")
  public ResponseEntity<BigDecimal> getBalance(@PathVariable String accountNumber) {
    return ResponseEntity.ok(accountService.getBalance(accountNumber));
  }

  @PutMapping("/{accountNumber}/blocked")
  public ResponseEntity<String> blockAccount(@PathVariable String accountNumber) {
    accountService.blockedAccount(accountNumber);
    return ResponseEntity.ok("Account blocked Successfully");
  }

  // SAGA step 1 --> Deduct balance --> called by Transaction service when
  // transaction is initiated..

  @PutMapping("/{accountNumber}/deduct")
  public ResponseEntity<String> deductBalance(@PathVariable String accountNumber, @RequestParam BigDecimal amount) {
    accountService.deductBalance(accountNumber, amount);
    return ResponseEntity.ok("Balance deducted Successfully");
  }

  // SAGA step 4 --> Compensating transaction endpoint ---> called by transaction
  // service in two scenarios
  // 1) Fraud Detected --> refund sender (undo step 1)
  // 2) Transaction Completed (credit reciever) --> we can make 2 seperate methods
  // 1) reciever 2) refund or we can make single method creditBalance in which we
  // will transfer the money back to the sender and simultaneously deducting the
  // same amount from the reciever.. --> and we will handle this in transaction
  // service

  // in method 1) we will transfer the mondey back to the sender (means reciever
  // will become the sender)...

  @PutMapping("/{accountNumber}/credit")
  public ResponseEntity<String> creditBalance(@PathVariable String accountNumber, @RequestParam BigDecimal amount) {

    accountService.creditBalance(accountNumber, amount);

    return ResponseEntity.ok("Balance Created Successfully");
  }

}
