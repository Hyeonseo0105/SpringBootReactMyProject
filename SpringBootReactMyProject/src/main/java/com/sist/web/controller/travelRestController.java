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
public class travelRestController {

	@Autowired
	private travelDAO dao;
	
	@GetMapping("/travel/travel_list_react")
	public Map travel_list(int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Gntravel> list=dao.travelListData(start);
		
		Map map=new HashMap();
		
	    int totalpage=dao.travelTotalPage();
	    final int BLOCK=10;
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
	@GetMapping("/travel/travel_home_react")
	public Map travel_home(int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Gntravel> list=dao.travelHomeData(start);
		List<Gntravel> tlist=dao.travelHome();
		Map map=new HashMap();
		
	    int totalpage=dao.travelTotalPage();
	    final int BLOCK=10;
	    int startPage=((page-1)/BLOCK*BLOCK)+1;
	    int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	    if(endPage>totalpage)
		    endPage=totalpage;
	   
	    map.put("curpage",page);
	    map.put("totalpage",totalpage);
	    map.put("startPage",startPage);
	    map.put("endPage", endPage);
	    map.put("list", list);
	    map.put("tlist", tlist);
		
		return map;
	}
	
	@GetMapping("/travel/travel_detail_react")
	public Gntravel travel_detail(int no)
	{
		Gntravel vo=dao.findByNo(no);
		return vo;
	}
	
	// 검색
	@RequestMapping("/travel/travel_find_react")
	public Map travel_find(int page,String search)
	{
		int rowSize=12;
	    int start=(rowSize*page)-rowSize;
	    List<Gntravel> list=dao.travelFindData(start, search);
	    
	    Map map=new HashMap();
	    int totalpage=dao.travelFindTotalPage(search);
	    
	    final int BLOCK=10;
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