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
public class foodRestController {

	@Autowired
	private foodDAO dao;
	
	@GetMapping("/food/list/{page}")
	public ResponseEntity<Map> food_list(@PathVariable("page") int page)
	{
		Map map=new HashMap();
		
		try
		{
			int rowSize=12;
			int start=(rowSize*page)-rowSize;
			List<Gnfood> list=dao.foodListData(start);	
			
		    int totalpage=dao.foodTotalPage();
		   
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
	
	@GetMapping("/food/detail/{no}")
	public ResponseEntity<Gnfood> food_detail(@PathVariable("no") int no)
	{
		Gnfood food=new Gnfood();
		try
		{
			food=dao.findByNo(no);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(food,HttpStatus.OK);
	}
	
	// 검색
	@RequestMapping("/food/find/{page}/{search}")
	public ResponseEntity<Map> travel_find(@PathVariable("page") int page, @PathVariable("search") String search)
	{
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start=(rowSize*page)-rowSize;
			List<Gnfood> ffList=dao.foodFindData(start, search);
			int count=dao.foodFindTotalPage(search);
			
			map.put("ffList", ffList);
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
