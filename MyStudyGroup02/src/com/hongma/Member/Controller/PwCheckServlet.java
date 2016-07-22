package com.hongma.Member.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Member.BEAN.MemberDAO;

/**
 * Servlet implementation class PwCheckServlet
 */
@WebServlet("/pwfind.do")
public class PwCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("Member/PwFind.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String m_name = request.getParameter("m_name");
		String m_id = request.getParameter("m_id");
		String m_email = request.getParameter("m_email");
		
		String m_pw = MemberDAO.getInstance().getM_PW(m_name, m_id, m_email);
		
		if(m_pw == null || m_pw.equals("")){
			messagePrint("no Info",response);
		}else{
			try {
				new SendEmail(m_email, m_pw);
				messagePrint("all finish. check your email",response);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				messagePrint("no email",response);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
	
	private void messagePrint(String msg, HttpServletResponse response) throws IOException{
		response.setContentType("UTF-8");
		PrintWriter out = response.getWriter();
        out.println("<script>alert('"+msg+"'); self.close();</script>");
        out.flush(); 
	}

}
