package com.bit2015.mysite3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite3.dao.NewBoardDao;
import com.bit2015.mysite3.vo.NewBoardVo;

@Service
public class NewBoardService {
	
	@Autowired
	NewBoardDao boardDao;
	
	public List<NewBoardVo> getList(){
		List<NewBoardVo> list = boardDao.getListAll();
		return list;
	}
	
	public NewBoardVo view(Long no){
		NewBoardVo boardVo = boardDao.getView(no);
		boardDao.increaseViewCount(no);
		return boardVo;
	}
	
	public void write(NewBoardVo vo){		
		boardDao.insert(vo);
	}
	
	public void delete(Long no){
		boardDao.delete(no);
	}
	
	public void modify(NewBoardVo vo){
		boardDao.modify(vo);
	}
	
}
