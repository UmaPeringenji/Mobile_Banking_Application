package com.bank.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Bank;
@Repository
public interface BankRepo extends CrudRepository<Bank, Long> {

}
