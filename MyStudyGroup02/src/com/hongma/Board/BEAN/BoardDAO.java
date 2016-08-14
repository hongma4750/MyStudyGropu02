package com.hongma.Board.BEAN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hongma.DBManager.DBManager;

public class BoardDAO {
 
	private BoardDAO(){
		
		
	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance(){
		return instance;
	}
	
	
	//board에 기본적으로 게시판형태로 뿌려주기 위해 리스트에 각 객체를 담아 리턴함
	public List<BoardDTO> selectAllBoards(){
		String sql = "select * from board order by b_num desc";
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				BoardDTO bdto = new BoardDTO();
				bdto.setB_num(rs.getInt("b_num"));
				bdto.setM_name(rs.getString("m_name"));
				bdto.setM_email(rs.getString("m_email"));
				bdto.setB_pass(rs.getString("b_pass"));
				bdto.setB_title(rs.getString("b_title"));
				bdto.setB_content(rs.getString("b_content"));
				bdto.setB_readcount(rs.getInt("b_readcount"));
				bdto.setB_writedate(rs.getTimestamp("b_writedate"));
				
				System.out.println("b_num : "+bdto.getB_num());
				
				list.add(bdto);
			}
		}catch(SQLException e ){
			System.out.println("여기?");
			System.out.println(e.getMessage());
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}

	//board에서 write 할 때 데이터 입력 할 때 사용
	public void insertBoard(BoardDTO boarddto){
		String sql = "insert into board (b_num,m_name,m_email,b_pass,b_title,b_content) values (board_seq.nextval,?,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boarddto.getM_name());
			pstmt.setString(2, boarddto.getM_email());
			pstmt.setString(3, boarddto.getB_pass());
			pstmt.setString(4, boarddto.getB_title());
			pstmt.setString(5, boarddto.getB_content());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DBManager.Close(conn, pstmt);
		}
	}
	
	//detail 부분 readcount 증가
	public void updateReadCount(int b_num){
		String sql = "update board set b_readcount = b_readcount+1 where b_num = ?";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b_num);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DBManager.Close(conn, pstmt);
		}
	}

	//detail 부분 객체 불러와서 뿌리기 용도
	public BoardDTO selectBoardDTO(int b_num){
		String sql = "select * from board where b_num=?";
		
		BoardDTO bodto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				bodto = new BoardDTO();
				int i =1;
				bodto.setB_num(rs.getInt(i++));
				bodto.setB_pass(rs.getString(i++));
				bodto.setM_name(rs.getString(i++));
				bodto.setM_email(rs.getString(i++));
				bodto.setB_title(rs.getString(i++));
				bodto.setB_content(rs.getString(i++));
				bodto.setB_readcount(rs.getInt(i++));
				bodto.setB_writedate(rs.getTimestamp(i++));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return bodto;
	}


}
