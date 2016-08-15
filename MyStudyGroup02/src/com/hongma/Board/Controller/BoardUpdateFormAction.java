package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;
import com.hongma.Board.BEAN.BoardDTO;

public class BoardUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp?mode=Board/BoardUpdate";
		
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateReadCount(b_num);
		
		BoardDTO dto = dao.selectBoardDTO(b_num);
		request.setAttribute("board", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
