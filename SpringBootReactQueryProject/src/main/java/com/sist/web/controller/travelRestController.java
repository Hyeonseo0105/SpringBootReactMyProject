package com.sist.web.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.dao.*;
import com.sist.web.entity.*;

@RestController
@CrossOrigin(origins = "*")
public class travelRestController {

	@Autowired
	private travelDAO dao;
	
	@GetMapping("/travel/list/{page}")
	public ResponseEntity<Map> travel_list(@PathVariable("page") int page)
	{
		Map map=new HashMap();
		
		try
		{
			int rowSize=12;
			int start=(rowSize*page)-rowSize;
			List<Gntravel> list=dao.travelListData(start);		
			
		    int totalpage=dao.travelTotalPage();
		   
		    map.put("curpage",page);
		    map.put("totalpage",totalpage);
		    map.put("list", list);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	 }
	
	@GetMapping("/travel/detail/{no}")
	public ResponseEntity<Gntravel> travel_detail(@PathVariable("no") int no)
	{
		Gntravel travel=new Gntravel();
		try
		{
			travel=dao.findByNo(no);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(travel,HttpStatus.OK);
	}
	
	// 검색
	@RequestMapping("/travel/find/{page}/{address}")
	public ResponseEntity<Map> travel_find(@PathVariable("page") int page, @PathVariable("address") String address)
	{
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start=(rowSize*page)-rowSize;
			List<Gntravel> tfList=dao.travelFindData(start, address);
			int count=dao.travelFindTotalPage(address);
			
			map.put("tfList", tfList);
			map.put("count", count);
			map.put("curpage", page);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
