package com.iboss.as.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
    @GeneratedValue
    private int accountId;
	
	@JsonProperty("accNumber")
    private String accountNumber;
	
	@JsonProperty("accBal")
	private String accountBalance;
	
	@JsonProperty("brCode")
    private String branchCode;
	
	@JsonProperty("usrId")
	private String userId;
}
