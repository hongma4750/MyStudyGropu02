package com.hongma.Board.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;
import com.hongma.Board.BEAN.BoardDTO;

public class BoardFindAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp?mode=Board/BoardFind";
		
		//request작업
		String findSelect = request.getParameter("findSelect");
		String findText = request.getParameter("findText");
		
		//DAO 작업
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> list = dao.findBoard(findSelect, findText);
		
		request.setAttribute("boardList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
