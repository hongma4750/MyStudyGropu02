package com.hongma.Member.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hongma.Member.BEAN.MemberDAO;

/**
 * Servlet implementation class DeleteMember
 */
@WebServlet("/deletemember.do")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Member/DeleteMember.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		MemberDAO memberDao = MemberDAO.getInstance();
		
		int result = memberDao.deleteMember(m_id,m_pw);
		
		if(result ==1){
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
			dispatcher.forward(request, response);
		}else {
			messagePrint("wrong info",response);
		}
	}

	private void messagePrint(String msg, HttpServletResponse response) throws IOException{
		response.setContentType("UTF-8");
		PrintWriter out = response.getWriter();
        out.println("<script>alert('"+msg+"'); location.href='deletemember.do';</script>");
        out.flush(); 
	}
}
