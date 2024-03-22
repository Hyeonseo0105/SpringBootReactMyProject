package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/*
 * NO int 
LOCAL text 
NAME text 
TITLE text 
POSTER text 
CONTENT text
 */
@Entity
@Getter
@Setter
public class Gnfood {

	@Id
	int no;
	String local,name,title,poster,content;
}
