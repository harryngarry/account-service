package com.iboss.as.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iboss.as.Entity.Account;
import com.iboss.as.Model.AccountDetail;
import com.iboss.as.Service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/newAccount")
	public Account createAccount(@RequestBody Account acc) throws JsonProcessingException {
		return accountService.createAccount(acc);
	}

	@GetMapping("getAccountDetail/{accountId}")
	public AccountDetail findAccountDetailsByAccountId(@PathVariable int accountId) throws JsonProcessingException {
		return accountService.findAccountDetailsByAccountId(accountId);
	}
}
