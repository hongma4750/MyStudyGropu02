package com.hongma.Board.BEAN;

import java.sql.Connection;
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









}
