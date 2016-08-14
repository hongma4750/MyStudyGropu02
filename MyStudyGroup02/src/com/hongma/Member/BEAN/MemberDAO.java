package com.hongma.Member.BEAN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
public class MemberDAO {

	private MemberDAO(){
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance(){
		return instance;
	}
	
	public Connection getConnection() throws NamingException, SQLException{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}

	private void queryClose(Connection conn,PreparedStatement pstmt, ResultSet rs){
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateClose(Connection conn,PreparedStatement pstmt){
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	//당근 로그인할때 사용되는거겟죠? id와 pw를 받아와 체크함
	//return 을 -1 , 0 , 1 로하여 로그인상태를 확인함
	public int userCheck(String m_id, String m_pw){
		int result = -1;
		
		String sql= "select m_pw from membertable where m_id=?";
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("m_pw") !=null && rs.getString("m_pw").equals(m_pw)){
					result=1;
				}else{
					result=0;
				}
			}else{
				result=-1;
			}
	
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				this.queryClose(conn, pstmt, rs);
		}

		return result;
	}
	
	
	
	
	
	//아이디로 회원 정보 가져옴
	//세션등록,
	public MemberDTO getMember(String m_id){
		
		MemberDTO memDto =null;
		String sql = "select * from membertable where m_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				memDto = new MemberDTO();
				
				int i=1;
				memDto.setM_name(rs.getString(i++));
				memDto.setM_id(rs.getString(i++));
				memDto.setM_pw(rs.getString(i++));
				memDto.setM_age(rs.getInt(i++));
				memDto.setM_admin(rs.getInt(i++));
				memDto.setM_email(rs.getString(i++));
				memDto.setM_phone1(rs.getInt(i++));
				memDto.setM_phone2(rs.getInt(i++));
				memDto.setM_phone3(rs.getInt(i++));
				memDto.setM_gender(rs.getString(i++));
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.queryClose(conn, pstmt, rs);

		}

		
		return memDto;
	}
	
	
	
	//아이디 중복 체크를 위한 메서드
	//해당 아이디 있으면 1 리턴
	//없으면 -1 리턴
	public int confirmID(String m_id){
		int result= -1;
		String sql = "select m_id from member where m_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				result=1;
			}else{
				result=-1;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("해당 회원 없음 가입 가능함");
		}finally{
			this.queryClose(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
	//회원 정보를 DB에 저장하는 메서드
	//회원가입할때 사용됨
	//m_admin 0 -> 					관리자 1->일반유저
	public int insertMember(MemberDTO mDto){
		int result = -1;
		String sql="insert into membertable values(?,?,?,?,1,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			int i=1;
			pstmt.setString(i++, mDto.getM_name());
			pstmt.setString(i++, mDto.getM_id());
			pstmt.setString(i++, mDto.getM_pw());
			pstmt.setInt(i++, mDto.getM_age());
			pstmt.setString(i++, mDto.getM_email());
			pstmt.setInt(i++, mDto.getM_phone1());
			pstmt.setInt(i++, mDto.getM_phone2());
			pstmt.setInt(i++, mDto.getM_phone3());
			pstmt.setString(i++, mDto.getM_gender());
			
			result = pstmt.executeUpdate();
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.updateClose(conn, pstmt);
		}
		
		
		
		
		
		return result;
	}
	
	

	//회원 정보를 변경하기 위한 메서드
	public int updateMember(MemberDTO mDto){
		int result=-1;
		
		String sql = "update membertable set m_pw=?, m_age=?, m_email=?, m_phone1=?,m_phone2=?,m_phone3=?,m_gender=?";
		
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,mDto.getM_pw());
			pstmt.setInt(2, mDto.getM_age());
			pstmt.setString(3,mDto.getM_email());
			pstmt.setInt(4, mDto.getM_phone1());
			pstmt.setInt(5, mDto.getM_phone2());
			pstmt.setInt(6, mDto.getM_phone3());
			pstmt.setString(7,mDto.getM_gender());
			result=pstmt.executeUpdate();
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.updateClose(conn, pstmt);
		}
		
		return result;
	}

	
	//아이디 알려줄때 사용함
	//리턴을 MemberDTO 정보를 넘겨줌
	public MemberDTO getMember(String m_name,String m_email){
		
		String sql = "select * from membertable where m_name=? and m_email=?";
		
		MemberDTO memberdto =null;
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m_name);
			pstmt.setString(2, m_email);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				memberdto = new MemberDTO();
				int i=1;
				memberdto.setM_name(rs.getString(i++));
				memberdto.setM_id(rs.getString(i++));
				memberdto.setM_pw(rs.getString(i++));
				memberdto.setM_age(rs.getInt(i++));
				memberdto.setM_admin(rs.getInt(i++));
				memberdto.setM_email(rs.getString(i++));
				memberdto.setM_phone1(rs.getInt(i++));
				memberdto.setM_phone2(rs.getInt(i++));
				memberdto.setM_phone3(rs.getInt(i++));
				memberdto.setM_gender(rs.getString(i++));
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.queryClose(conn, pstmt, rs);
		}
		
		
		return memberdto;
		
	}

	
	//비밀번호 찾기!!!!
	//이번엔 리턴을 스트링으로 해보자
	public String getM_PW(String m_name, String m_id, String m_email){
		String m_pw=null;
		
		String sql = "select m_pw from membertable where m_name=? and m_id=? and m_email=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn =getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m_name);
			pstmt.setString(2, m_id);
			pstmt.setString(3, m_email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				m_pw = new String();
				m_pw = rs.getString("m_pw");
			}else {
				m_pw = null;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.queryClose(conn, pstmt, rs);
		}
		
		
		return m_pw;
		
	}

	
	
	//탈퇴기능!!!
	//그냥 delete table 용임
	//리턴을 숫자로 그리고 회원정보가 틀렷다 맞앗다 표시
	public int deleteMember(String m_id,String m_pw){
		int result = -1;
		
		String sql ="delete from membertable where m_id=? and m_pw=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			
			result=pstmt.executeUpdate();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.updateClose(conn, pstmt);
		}
		
		
		return result;
	}
}
