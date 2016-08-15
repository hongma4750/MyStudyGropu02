package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;
import com.hongma.Board.BEAN.BoardDTO;

public class BoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		
		dto.setB_num(Integer.parseInt(request.getParameter("b_num")));
		dto.setM_name(request.getParameter("m_name"));
		dto.setB_pass(request.getParameter("b_pass"));
		dto.setM_email(request.getParameter("m_email"));
		dto.setB_title(request.getParameter("b_title"));
		dto.setB_content(request.getParameter("b_content"));
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(dto);
		
		new BoardListAction().execute(request, response);
		
	}

}
