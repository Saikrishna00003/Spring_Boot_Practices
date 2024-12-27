package com.sai.studentdetails.model;

//import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*@Document*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Student {
	private int id;
	private String name;
	private String branch;
	private int marks;
	private String address;

	
	
}
