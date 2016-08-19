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

	private BoardDAO() {

	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	// board에 기본적으로 게시판형태로 뿌려주기 위해 리스트에 각 객체를 담아 리턴함
	public List<BoardDTO> selectAllBoards() {
		String sql = "select * from board where b_del != 1 order by b_ref DESC, b_step ASC";

		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardDTO bdto = new BoardDTO();
				int i = 1;

				bdto.setB_num(rs.getInt(i++));
				bdto.setB_pass(rs.getString(i++));
				bdto.setM_name(rs.getString(i++));
				bdto.setM_email(rs.getString(i++));
				bdto.setB_title(rs.getString(i++));
				bdto.setB_content(rs.getString(i++));
				bdto.setB_readcount(rs.getInt(i++));
				bdto.setB_writedate(rs.getTimestamp(i++));
				bdto.setM_id(rs.getString(i++));
				bdto.setB_ref(rs.getInt(i++));
				bdto.setB_step(rs.getInt(i++));
				bdto.setB_depth(rs.getInt(i++));
				bdto.setB_parent(rs.getInt(i++));
				bdto.setB_del(rs.getInt(i++));

				System.out.println("b_num : " + bdto.getB_num());

				list.add(bdto);
			}
		} catch (SQLException e) {
			System.out.println("여기?");
			System.out.println(e.getMessage());
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}

	// board에서 write 할 때 데이터 입력 할 때 사용
	public void insertBoard(BoardDTO boarddto) {
		String sql = "insert into board values (board_seq.nextval,?,?,?,?,?,0,sysdate,?,"
				+ "(select NVL(max(b_ref),0)+1 from board),0,0,board_seq.nextval,0)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boarddto.getB_pass());
			pstmt.setString(2, boarddto.getM_name());
			pstmt.setString(3, boarddto.getM_email());
			pstmt.setString(4, boarddto.getB_title());
			pstmt.setString(5, boarddto.getB_content());
			pstmt.setString(6, boarddto.getM_id());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBManager.Close(conn, pstmt);
		}
	}

	// detail 부분 readcount 증가
	public void updateReadCount(int b_num) {
		String sql = "update board set b_readcount = b_readcount+1 where b_num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, b_num);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBManager.Close(conn, pstmt);
		}
	}

	// detail 부분 객체 불러와서 뿌리기 용도
	public BoardDTO selectBoardDTO(int b_num) {
		String sql = "select * from board where b_num=?";

		BoardDTO bodto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, b_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bodto = new BoardDTO();
				int i = 1;
				bodto.setB_num(rs.getInt(i++));
				bodto.setB_pass(rs.getString(i++));
				bodto.setM_name(rs.getString(i++));
				bodto.setM_email(rs.getString(i++));
				bodto.setB_title(rs.getString(i++));
				bodto.setB_content(rs.getString(i++));
				bodto.setB_readcount(rs.getInt(i++));
				bodto.setB_writedate(rs.getTimestamp(i++));
				bodto.setM_id(rs.getString(i++));
				bodto.setB_ref(rs.getInt(i++));
				bodto.setB_step(rs.getInt(i++));
				bodto.setB_depth(rs.getInt(i++));
				bodto.setB_parent(rs.getInt(i++));
				bodto.setB_del(rs.getInt(i++));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return bodto;
	}

	// 게시판 업로드
	public void updateBoard(BoardDTO dto) {
		String sql = "update board set m_name=?,m_email=?,b_pass=?,b_title=?,b_content=?, b_ref=?, b_step=? , b_depth = ?where b_num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setString(i++, dto.getM_name());
			pstmt.setString(i++, dto.getM_email());
			pstmt.setString(i++, dto.getB_pass());
			pstmt.setString(i++, dto.getB_title());
			pstmt.setString(i++, dto.getB_content());
			pstmt.setInt(i++, dto.getB_ref());
			pstmt.setInt(i++, dto.getB_step());
			pstmt.setInt(i++, dto.getB_depth());
			pstmt.setInt(i++, dto.getB_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBManager.Close(conn, pstmt);
		}
	}

	// 비밀번호 체크
	public BoardDTO checkPassWord(String b_pass, int b_num) {
		String sql = "select * from board where b_pass=? and b_num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BoardDTO dto = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b_pass);
			pstmt.setInt(2, b_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new BoardDTO();

				int i = 1;
				dto.setB_num(rs.getInt(i++));
				dto.setB_pass(rs.getString(i++));
				dto.setM_name(rs.getString(i++));
				dto.setM_email(rs.getString(i++));
				dto.setB_title(rs.getString(i++));
				dto.setB_content(rs.getString(i++));
				dto.setB_readcount(rs.getInt(i++));
				dto.setB_writedate(rs.getTimestamp(i++));
				dto.setM_id(rs.getString(i++));
				dto.setB_ref(rs.getInt(i++));
				dto.setB_step(rs.getInt(i++));
				dto.setB_depth(rs.getInt(i++));
				dto.setB_parent(rs.getInt(i++));
				dto.setB_del(rs.getInt(i++));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return dto;
	}

	// 게시판 삭제
	// 일단 이걸로 만들고 답글 달렸을때 또 수정 요망
	public void deleteBoard(int b_num) {
		String sql = "update board set b_del = 1 where b_num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, b_num);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBManager.Close(conn, pstmt);
		}
	}
	
	//부모글 삭제시 부모글을 가지는 모든 row 의 parent를 0으로 수정한다.
	public void deleteSetBoard(int b_num){
		String sql = "update board set b_parent = 0 where b_parent = ?";
		
		Connection conn = null;
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

	// 게시판 검색
	// 3가지 검색 1.작성자 검색 == findName<일치검색> 2.글 검색 == findTitle<like작업> 3. 제목검색
	// ==findContent<like작업>
	public List<BoardDTO> findBoard(String findSelect, String findText) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = null;
		if (findSelect.equals("findName")) {
			sql = "select * from board where m_name ='" + findText + "'";
		} else if (findSelect.equals("findTitle")) {
			sql = "select * from board where regexp_like(b_title,'" + findText + "')";
		} else if (findSelect.equals("findContent")) {
			sql = "select * from board where regexp_like(b_content,'" + findText + "')";
		}

		BoardDTO dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new BoardDTO();

				int i = 1;
				dto.setB_num(rs.getInt(i++));
				dto.setB_pass(rs.getString(i++));
				dto.setM_name(rs.getString(i++));
				dto.setM_email(rs.getString(i++));
				dto.setB_title(rs.getString(i++));
				dto.setB_content(rs.getString(i++));
				dto.setB_readcount(rs.getInt(i++));
				dto.setB_writedate(rs.getTimestamp(i++));
				dto.setM_id(rs.getString(i++));
				dto.setB_ref(rs.getInt(i++));
				dto.setB_step(rs.getInt(i++));
				dto.setB_depth(rs.getInt(i++));
				dto.setB_parent(rs.getInt(i++));
				dto.setB_del(rs.getInt(i++));

				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 답글 입력
	public void insertAnswer(int b_num, BoardDTO dto) {
		String sql1 = "update board set b_step = b_step+1 where b_ref=(select b_ref from board where b_num = ?)"
				+ " and b_step > (select b_step from board where b_num = ?)";

		String sql2 = "insert into board " + "values (board_seq.nextval," + "?,?,?,?,?,0,sysdate,?,"
				+ "(select b_ref from board where b_num = ?)," + "(select b_step from board where b_num = ?)+1,"
				+ "(select b_depth from board where b_num=?)+1," + "?,0)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql1);

			pstmt.setInt(1, b_num);
			pstmt.setInt(2, b_num);
			result = pstmt.executeUpdate();

			pstmt.clearParameters();

			pstmt = conn.prepareStatement(sql2);
			int i = 1;
			pstmt.setString(i++, dto.getB_pass());
			pstmt.setString(i++, dto.getM_name());
			pstmt.setString(i++, dto.getM_email());
			pstmt.setString(i++, dto.getB_title());
			pstmt.setString(i++, dto.getB_content());
			pstmt.setString(i++, dto.getM_id());
			pstmt.setInt(i++, b_num);
			pstmt.setInt(i++, b_num);
			pstmt.setInt(i++, b_num);
			pstmt.setInt(i++, b_num);

			result = pstmt.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				conn.rollback(); // 잘못됐을때 데이터 돌려줌
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			DBManager.close(conn, pstmt, rs);
		}
	}

}
