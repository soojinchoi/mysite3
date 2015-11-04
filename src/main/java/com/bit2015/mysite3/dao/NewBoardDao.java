package com.bit2015.mysite3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite3.vo.NewBoardVo;

@Repository
public class NewBoardDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<NewBoardVo> getListAll(){
		
		List<NewBoardVo> list = sqlSession.selectList("board.getListAll");			
		return list;
	}
	
	public NewBoardVo getView(Long no){
		NewBoardVo boardVo = sqlSession.selectOne("board.getView", no);
		return boardVo;			
	}
	
	public void insert(NewBoardVo vo){	
		sqlSession.insert("board.insert",vo);
	}

	public void delete(long no){
		sqlSession.delete("board.delete",no);		
	}
	
	public void modify( NewBoardVo vo)  {
		sqlSession.update("board.update", vo );
	}
	
	public void increaseViewCount( long no ) {
		sqlSession.update("board.viewCnt",no);
	}

		
		
		/*public List<BoardVo> search( String keyword ) {
			List<BoardVo> list = null;	
			try{
					Connection conn = getConnection();
					
					//2. SQL prepare
					String sql = "SELECT NO, TITLE, CONTENT, MEMBER_NO, MEMBER_NAME, VIEW_CNT, REG_DATE FROM BOARD WHERE TITLE LIKE ? ORDER BY NO DESC";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					//3. BINDING
					pstmt.setString(1, "%" + keyword + "%");
					
					//4. EXECUTE
					ResultSet rs = pstmt.executeQuery();
					
					//5. Handling
					list = new ArrayList<BoardVo>();
					
					while ( rs.next() ) {
						BoardVo vo = new BoardVo();
						Long no = rs.getLong(1);
						String title = rs.getString(2);
						String content = rs.getString(3);
						Long memberNo = rs.getLong(4);
						String memberName = rs.getString(5);
						Long viewCnt = rs.getLong(6);
						String regDate = rs.getString(7);
						
						vo.setNo(no);
						vo.setTitle(title);
						vo.setContent(content);
						vo.setMemberNo(memberNo);
						vo.setMemberName(memberName);
						vo.setViewCnt(viewCnt);
						vo.setRegDate(regDate);
						
						list.add( vo );
					}
					
					rs.close();
					pstmt.close();
					conn.close();
				}catch(SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("SQL 오류-"+e);
				}	
					return list;
			
		}*/

}
