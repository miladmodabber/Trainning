package com.test.payment.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@EqualsAndHashCode(of="id")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String id ; 
	private String name ;
	private String family ;
	private Date birthDay ;
	private String sex ;
	private UserType type ;
	private Date createDate ;

}
