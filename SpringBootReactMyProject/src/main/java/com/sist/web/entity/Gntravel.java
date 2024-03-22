package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/*
 * TYPE int 
GENRE text 
NO int 
TITLE text 
POSTER1 text 
POSTER2 text 
POSTER3 text 
MANAGE text 
ADDRESS text 
PHONE text 
CONTENT text
 */
@Entity
@Getter
@Setter
public class Gntravel {

	@Id
	private int no;
	private int type;
	private String genre,title,poster1,poster2,poster3,manage,address,phone,content;
}
