package com.sai.studentdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class StudentAddress {
	private Student student;
	private Address address;

}
