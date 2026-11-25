package io.github.shashankkumar8558.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.shashankkumar8558.accountservice.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
