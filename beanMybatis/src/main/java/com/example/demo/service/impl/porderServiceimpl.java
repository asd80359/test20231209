package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.porderMapper;
import com.example.demo.service.porderService;
import com.example.demo.vo.porder;
import com.mysql.cj.Session;
@Service
public class porderServiceimpl implements porderService{
	@Autowired
		porderMapper pm;

		
	
	@Override
	public void addporder(porder o) {
		pm.add(o);
		
	}

	@Override
	public List<porder> findAll() {
		
		return pm.selectporderAll();
	}

}
