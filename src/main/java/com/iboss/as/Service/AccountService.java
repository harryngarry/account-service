package com.iboss.as.Service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iboss.as.Entity.Account;
import com.iboss.as.Model.AccountDetail;
import com.iboss.as.Model.User;
import com.iboss.as.Repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RestTemplate template;

	@Autowired
	private DiscoveryClient client;

	Logger logger = LoggerFactory.getLogger(AccountService.class);

	
	public Account createAccount(Account acc) throws JsonProcessingException {
		logger.info("Account-Service Request : {}", new ObjectMapper().writeValueAsString(acc));
		return accountRepository.save(acc);
	}
	
	public AccountDetail findAccountDetailsByAccountId(int accountId) throws JsonProcessingException {
		Account acc = accountRepository.findByAccountId(accountId);
		/*
		 * URI uri = client.getInstances("http://localhost:9091").stream().map(si ->
		 * si.getUri()).findFirst() .map(s ->
		 * s.resolve("/user/getUser/"+acc.getUserId())).get();
		 */
		User usr = template.getForObject("http://localhost:9191/user/getUser/"+acc.getUserId(), User.class);

		AccountDetail accDetail = new AccountDetail();
		accDetail.setAccountBalance(acc.getAccountBalance());
		accDetail.setAccountNumber(acc.getAccountNumber());
		accDetail.setBranchCode(acc.getBranchCode());
		accDetail.setUserName(usr.getUserName());
		accDetail.setContactNumber(usr.getContactNumber());
		logger.info("AccountService findAccountDetailsByAccountId : {}", new ObjectMapper().writeValueAsString(accDetail));
		return accDetail;
	}

}
