package com.iboss.as.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountDetail {
	
	@JsonProperty("accNumber")
    private String accountNumber;
	
	@JsonProperty("accBal")
	private String accountBalance;
	
	@JsonProperty("brCode")
    private String branchCode;
	
	@JsonProperty("name")
    private String userName;
	
	@JsonProperty("number")
    private String contactNumber;

}
