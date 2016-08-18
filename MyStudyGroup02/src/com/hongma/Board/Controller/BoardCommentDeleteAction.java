package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.CommentDAO;

public class BoardCommentDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//request
		int com_seq = Integer.parseInt(request.getParameter("com_seq"));
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		//dao
		
		CommentDAO dao = CommentDAO.getInstance();
		dao.deleteComment(com_seq);
		
		
		new BoardDetail(b_num+"").execute(request, response);
	}

}
