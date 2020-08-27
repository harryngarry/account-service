package com.iboss.as.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iboss.as.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	Account findByAccountId(int accountId);

}
