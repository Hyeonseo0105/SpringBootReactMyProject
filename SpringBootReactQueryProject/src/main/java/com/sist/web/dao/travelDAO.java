package com.sist.web.dao;

import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sist.web.entity.*;

public interface travelDAO extends JpaRepository<Gntravel, Integer>{

	@Query(value = "SELECT * FROM gntravel "
			+"ORDER BY no ASC LIMIT :start,12",nativeQuery = true)
	public List<Gntravel> travelListData(@Param("start") Integer start);
	
	//홈
	@Query(value = "SELECT * FROM gntravel WHERE type=2 "
			+"ORDER BY no DESC LIMIT 0,3",nativeQuery = true)
	public List<Gntravel> travelHomeData();
	
	@Query(value = "SELECT * FROM gntravel "
			+ "WHERE title LIKE '%산청%' "
			+ "LIMIT 0,2",nativeQuery = true)
	public List<Gntravel> travelHome();
	
	@Query(value = "SELECT COUNT(*) FROM gntravel",nativeQuery = true)
	public int travelTotalPage();
	
	public Gntravel findByNo(int no);
	
	@Query(value = "SELECT * FROM gntravel "
			+"WHERE manage LIKE CONCAT('%',:address,'%') "
			+"ORDER BY no ASC limit :start,12",nativeQuery = true)
	public List<Gntravel> travelFindData(@Param("start") Integer start,@Param("address") String address);
	
	@Query(value = "SELECT COUNT(*) FROM gntravel "
			+"WHERE manage LIKE CONCAT('%',:address,'%')",nativeQuery = true)
	public int travelFindTotalPage(@Param("address") String address);
}
