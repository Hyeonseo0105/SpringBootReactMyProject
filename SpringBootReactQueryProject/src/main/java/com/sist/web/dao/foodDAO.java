package com.sist.web.dao;

import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sist.web.entity.*;

public interface foodDAO extends JpaRepository <Gnfood, Integer>{

	@Query(value = "SELECT * FROM gnfood "
			+"ORDER BY no ASC LIMIT :start,12",nativeQuery = true)
	public List<Gnfood> foodListData(@Param("start") Integer start);
	
	@Query(value = "SELECT * FROM gnfood WHERE local='산청'",nativeQuery = true)
	public List<Gnfood> foodHomeData();
	
	
	@Query(value = "SELECT COUNT(*) FROM gnfood",nativeQuery = true)
	public int foodTotalPage();
	
	public Gnfood findByNo(int no);
	
	@Query(value = "SELECT * FROM gnfood "
			+"WHERE (title LIKE CONCAT('%',:search,'%') OR local LIKE CONCAT('%',:search,'%')) "
			+"ORDER BY no ASC limit :start,12",nativeQuery = true)
	public List<Gnfood> foodFindData(@Param("start") Integer start,@Param("search") String search);
	
	@Query(value = "SELECT COUNT(*) FROM gnfood "
			+"WHERE (title LIKE CONCAT('%',:search,'%') OR local LIKE CONCAT('%',:search,'%'))",nativeQuery = true)
	public int foodFindTotalPage(@Param("search") String search);
}