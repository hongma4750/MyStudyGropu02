package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;
import com.hongma.Board.BEAN.BoardDTO;
 
public class BoardDetail implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp?mode=Board/BoardDetail";
		
		String num = request.getParameter("b_num");
		int b_num = Integer.parseInt(num);
		
		BoardDAO bodao = BoardDAO.getInstance();
		bodao.updateReadCount(b_num);
		BoardDTO bodto = bodao.selectBoardDTO(b_num);
		
		request.setAttribute("board", bodto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
