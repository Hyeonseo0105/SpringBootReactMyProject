package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "jpaboard")
@DynamicUpdate
@Data
@NoArgsConstructor
public class Board {
	
  @Id
  private int no;
  private String name;
  private String subject;
  private String content;
  
  @Column(insertable = true,updatable = false)
  private String pwd;
  
  @Column(insertable = true,updatable = false)
  private String regdate;
  private int hit;
  
  @PrePersist
  public void regdate() {
	  this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
  }

  public Board(String name, String subject, String content, String pwd) {
	super();
	this.name = name;
	this.subject = subject;
	this.content = content;
	this.pwd = pwd;
  }
}