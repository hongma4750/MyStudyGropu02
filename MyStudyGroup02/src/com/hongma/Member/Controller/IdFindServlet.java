package com.hongma.Member.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Member.BEAN.MemberDAO;
import com.hongma.Member.BEAN.MemberDTO;
 
/**
 * Servlet implementation class IdFindServlet
 */
@WebServlet("/Idfind.do")
public class IdFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdFindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Member/IdFind.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		MemberDTO memberdto = MemberDAO.getInstance().getMember(request.getParameter("m_id"),request.getParameter("m_email"));
		String url = "Member/Login.jsp";

		request.setAttribute("memberdto", memberdto);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Member/IdFind.jsp");
		dispatcher.forward(request, response);
	}
	
	private void messagePrint(String msg, HttpServletResponse response) throws IOException{
		response.setContentType("UTF-8");
		PrintWriter out = response.getWriter();
        out.println("<script>alert('"+msg+"'); self.close();</script>");
        out.flush(); 
	}

}
