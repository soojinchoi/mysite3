package com.bit2015.mysite3.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite3.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public GuestbookVo get( Long no ) {
		GuestbookVo vo = sqlSession.selectOne( "guestbook.get",  no );
		return vo;
	}
	
	public List<GuestbookVo> getList( int page ) {
		List<GuestbookVo> list = sqlSession.selectList( "guestbook.listbypage", page );
		return list;
	}
	
	public void insert( GuestbookVo vo ) {
		sqlSession.insert( "guestbook.insert", vo );
	}
	
	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = sqlSession.selectList( "guestbook.list" );
		return list;
	}
	
	public Boolean delete( GuestbookVo vo ) {
		int countDeleted = sqlSession.delete( "guestbook.delete", vo );
		return ( countDeleted == 1 );
	}	
}