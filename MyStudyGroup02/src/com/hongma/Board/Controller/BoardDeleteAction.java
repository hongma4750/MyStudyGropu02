package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(b_num);
		dao.deleteSetBoard(b_num);
		
		new BoardListAction().execute(request, response);
		
	}

}
