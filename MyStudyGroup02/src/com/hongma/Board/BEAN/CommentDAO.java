package com.hongma.Board.BEAN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hongma.DBManager.DBManager;

public class CommentDAO {

	private CommentDAO() {

	}

	private static CommentDAO instance = new CommentDAO();

	public static CommentDAO getInstance() {
		return instance;
	}
	
	
	//BoardDetail에 들어가면서 작업 시작한다
	//댓글의 DTO를 뽑아 리스트에 담아 리턴한다.
	public List<CommentVO> selectAllComment(int b_num){
		List<CommentVO> list = new ArrayList<CommentVO>();
		
		String sql = "select * from board_comment where b_num = ?";
		
		CommentVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b_num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				vo = new CommentVO();
				int i = 1;
				vo.setCom_seq(rs.getInt(i++));
				vo.setB_num(rs.getInt(i++));
				vo.setM_id(rs.getString(i++));
				vo.setCom_content(rs.getString(i++));
				vo.setCom_writedate(rs.getTimestamp(i++));
				vo.setCom_ref(rs.getInt(i++));
				vo.setCom_step(rs.getInt(i++));
				vo.setCom_depth(rs.getInt(i++));
				vo.setCom_parent(rs.getInt(i++));
				vo.setCom_del(rs.getInt(i++));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DBManager.close(conn, pstmt, rs);
			
		}
		return list;
	}
	
	
	//댓글 입력시
	public void insertComment(int b_num, String m_id, String com_content){
		String sql = "insert into board_comment values (board_comment_seq.nextval,?,?,?,sysdate,"+
						"(select NVL(max(com_ref),0)+1 from board_comment),0,0,0,0)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b_num);
			pstmt.setString(2, m_id);
			pstmt.setString(3, com_content);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DBManager.Close(conn, pstmt);
		}
	}

	//댓글 수정시 사용
	public void updateComment(CommentVO vo){
		String sql = "UPDATE board_comment SET com_content=?, com_ref=?, com_step=?, com_depth=? where com_seq = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCom_content());
			pstmt.setInt(2, vo.getCom_ref());
			pstmt.setInt(3, vo.getCom_step());
			pstmt.setInt(4, vo.getCom_depth());
			pstmt.setInt(5, vo.getCom_seq());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DBManager.Close(conn, pstmt);
		}
	}

	
	//댓글 삭제시 사용
	//del 값을 1로 바꿔준다 
	public void deleteComment(int com_seq){
		String sql = "update board_comment set com_del = 1 where com_seq = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, com_seq);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DBManager.Close(conn, pstmt);
			
		}
	}
}
