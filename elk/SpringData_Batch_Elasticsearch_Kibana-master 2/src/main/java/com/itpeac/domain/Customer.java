
package com.itpeac.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonFormat;


// Extract table from MySQL to Elasticsearch
@Document(indexName = "customers", type = "customer")
public class Customer {

	@Id
	private int id;

	private String firstname;

	private String lastname;

	
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	// private Date birthdate; 

	

	public Customer(int id, String firstname, String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		

	}

	

	public int getId() {
		return id;
	}

	public String getFistname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}


}

