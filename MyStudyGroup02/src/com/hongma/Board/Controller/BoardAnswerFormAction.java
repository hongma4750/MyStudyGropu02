package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;
import com.hongma.Board.BEAN.BoardDTO;

public class BoardAnswerFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//request작업
		int b_num = Integer.parseInt(request.getParameter("parent_b_num"));
		
		String m_name = request.getParameter("m_name");
		String m_id = request.getParameter("m_id");
		String b_pass = request.getParameter("b_pass");
		String m_email = request.getParameter("m_email");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		
		BoardDTO dto = new BoardDTO();
		dto.setM_name(m_name);
		dto.setM_id(m_id);
		dto.setB_pass(b_pass);
		dto.setM_email(m_email);
		dto.setB_title(b_title);
		dto.setB_content(b_content);
		
		
		//dao 작업
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertAnswer(b_num, dto);
		
		new BoardListAction().execute(request, response);
		
	}

}
