package com.sai.studentdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Address {

	int id;
	String city;
	int pincode;
	String state;
}
