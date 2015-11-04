package com.bit2015.mysite3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite3.dao.BoardDao;
import com.bit2015.mysite3.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	public List<BoardVo> getList(){
		List<BoardVo> list = boardDao.getListAll();
		return list;
	}
	
	public BoardVo view(Long no){
		BoardVo boardVo = boardDao.getView(no);
		boardDao.increaseViewCount(no);
		return boardVo;
	}
	
	public void write(BoardVo vo){
		boardDao.insert(vo);
	}
	
	public void delete(Long no){
		boardDao.delete(no);
	}
	
	public void modify(BoardVo vo){
		boardDao.modify(vo);
	}
	
}
