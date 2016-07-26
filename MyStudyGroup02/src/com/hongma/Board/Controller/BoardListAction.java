package com.hongma.Board.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;
import com.hongma.Board.BEAN.BoardDTO;

public class BoardListAction implements Action{

	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Board/BoardList.jsp";
		
		BoardDAO bDAO = BoardDAO.getInstance();
		
		List<BoardDTO> boardlist = bDAO.selectAllBoards();
		
		request.setAttribute("boardList", boardlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
