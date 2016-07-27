package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;
import com.hongma.Board.BEAN.BoardDTO;

public class BoardWriteAFAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO boarddto = new BoardDTO();
		
		boarddto.setM_name(request.getParameter("m_name"));
		boarddto.setB_pass(request.getParameter("b_pass"));
		boarddto.setM_email(request.getParameter("m_email"));
		boarddto.setB_title(request.getParameter("b_title"));
		boarddto.setB_content(request.getParameter("b_content"));
		
		BoardDAO bodao = BoardDAO.getInstance();
		bodao.insertBoard(boarddto);
		
		new BoardListAction().execute(request, response);
		
	}

}
