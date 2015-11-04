package com.bit2015.mysite3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite3.dao.GuestbookDao;
import com.bit2015.mysite3.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getList(){
		List<GuestbookVo> list = guestbookDao.getList();
		return list;
	}
	
	public void insert( GuestbookVo vo ){
		guestbookDao.insert(vo);
	}
	
	public void delete( GuestbookVo vo ){
		guestbookDao.delete(vo);
	}
}
