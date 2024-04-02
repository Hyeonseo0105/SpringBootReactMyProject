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
public class MainRestController {

	@Autowired
	private travelDAO tDao;
	
	@Autowired
	private foodDAO fDao;
	
	// 홈
	@GetMapping("/main")
	public Map home()
	{
		List<Gntravel> list=tDao.travelHomeData();
		List<Gntravel> tlist=tDao.travelHome();
		
		List<Gnfood> flist=fDao.foodHomeData();
		
		Map map=new HashMap();
		
	    map.put("list", list);
	    map.put("tlist", tlist);	    
	    map.put("flist", flist);
		
		return map;
	}
}
