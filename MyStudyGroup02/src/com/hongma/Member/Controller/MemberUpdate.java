package com.hongma.Member.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Member.BEAN.MemberDAO;
import com.hongma.Member.BEAN.MemberDTO;


/**
 * Servlet implementation class MemberUpdate
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
		RequestDispatcher dispatcher = request.getRequestDispatcher("Member/MemberUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		

		MemberDTO mDto = new MemberDTO();
		mDto.setM_name(request.getParameter("m_name"));
		mDto.setM_id(request.getParameter("m_id"));
		mDto.setM_pw(request.getParameter("m_pw"));
		mDto.setM_age(Integer.parseInt(request.getParameter("m_age")));
		mDto.setM_email(request.getParameter("m_email"));
		mDto.setM_phone1(Integer.parseInt(request.getParameter("m_phone1")));
		mDto.setM_phone2(Integer.parseInt(request.getParameter("m_phone2")));
		mDto.setM_phone3(Integer.parseInt(request.getParameter("m_phone3")));
		mDto.setM_gender(request.getParameter("m_gender"));
		
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMember(mDto);
		response.sendRedirect("login.do");
	}

}
