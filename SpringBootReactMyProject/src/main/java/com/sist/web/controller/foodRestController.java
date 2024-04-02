package com.sist.web.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.dao.*;
import com.sist.web.entity.*;

@RestController
@CrossOrigin(origins = "*")
public class foodRestController {

	@Autowired
	private foodDAO dao;
	
	@GetMapping("/food/food_list_react")
	public Map food_list(int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Gnfood> list=dao.foodListData(start);
		Map map=new HashMap();
	    int totalpage=dao.foodTotalPage();
	    final int BLOCK=3;
	    int startPage=((page-1)/BLOCK*BLOCK)+1;
	    int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	    if(endPage>totalpage)
		    endPage=totalpage;
	   
	    map.put("curpage",page);
	    map.put("totalpage",totalpage);
	    map.put("startPage",startPage);
	    map.put("endPage", endPage);
	    map.put("list", list);
		
		return map;
	}
	
	// 홈
	@GetMapping("/food/food_home_react")
	public Map food_home_list()
	{
		List<Gnfood> list=dao.foodHomeData();
		Map map=new HashMap();
	    
	    map.put("list", list);
		
		return map;
	}
	
	@GetMapping("/food/food_detail_react")
	public Gnfood food_detail(int no)
	{
		Gnfood vo=dao.findByNo(no);
		return vo;
	}
	
	// 검색
	@RequestMapping("/food/food_find_react")
	public Map food_find(int page,String search)
	{
		int rowSize=12;
	    int start=(rowSize*page)-rowSize;
	    List<Gnfood> list=dao.foodFindData(start, search);
	    
	    Map map=new HashMap();
	    int totalpage=dao.foodFindTotalPage(search);
	    
	    final int BLOCK=3;
	    int startPage=((page-1)/BLOCK*BLOCK)+1;
	    int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	    
	    if(endPage>totalpage)
		    endPage=totalpage;
	   
	    map.put("curpage",page);
	    map.put("totalpage",totalpage);
	    map.put("startPage",startPage);
	    map.put("endPage", endPage);
	    map.put("list", list);
	    
	    return map;
	}
	
}