package com.bit2015.mysite3.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite3.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public void insert(UserVo vo){//회원가입 메소드
		sqlSession.insert("user.insert", vo);
	}
	
	public void update(UserVo vo){//회원정보수정 메소드
		sqlSession.update("user.update", vo);
	}
	
	public UserVo get(String email){// email 중복체크
		UserVo vo = sqlSession.selectOne( "user.getByEmail", email );
		return vo;
	}
		
	public UserVo get(UserVo vo){//login할 때 사용되는 메소드
		UserVo userVo = sqlSession.selectOne("user.getByEmailAndPassword", vo);
		return userVo;
	}
	
	public UserVo get(Long no){//회원정보수정시, 원래 정보 불러올때
		UserVo vo = sqlSession.selectOne("user.getByNo", no);		
		return vo;
	}


}
