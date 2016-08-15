package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.CommentDAO;

public class BoardCommentWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//request
		
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		String m_id = request.getParameter("m_id");
		String com_content = request.getParameter("com_content");
		
		//dao
		
		CommentDAO dao = CommentDAO.getInstance();
		dao.insertComment(b_num, m_id, com_content);
		
		new BoardDetail().execute(request, response);
		
	}

}
