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
import com.hongma.Member.BEAN.MemberDTO;
 
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "Member/Login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") !=null){
			url="Main.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="Member/Login.jsp";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("utf-8");
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(m_id, m_pw);
		
		if(result==1){
			MemberDTO mDto = mDao.getMember(m_id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mDto);
			//messagePrint("로그인성공",response);
			url="Main.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		}else if(result==0){
			messagePrint("wrong password",response);
		}else if(result==-1){
			messagePrint("no id!",response);
		}
		
		
	}

	

	private void messagePrint(String msg, HttpServletResponse response) throws IOException{
		response.setContentType("UTF-8");
		PrintWriter out = response.getWriter();
        out.println("<script>alert('"+msg+"'); location.href='Index.jsp';</script>");
        out.flush(); 
	}
}
