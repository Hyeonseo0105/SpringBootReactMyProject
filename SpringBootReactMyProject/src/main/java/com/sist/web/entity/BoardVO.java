package com.sist.web.entity;
// * , 원하는 컬럼만 읽어 올때 

public interface BoardVO {
  public int getNo();
  public String getName();
  public String getSubject();
  public String getRegdate();
  public int getHit();
  
}