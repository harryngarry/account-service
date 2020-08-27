package com.iboss.as.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class User {

	@JsonProperty("name")
    private String userName;
	
	@JsonProperty("number")
    private String contactNumber;
}
