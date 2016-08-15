package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;
import com.hongma.Board.BEAN.BoardDTO;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "null";
		
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		String b_pass = request.getParameter("b_pass");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.selectBoardDTO(b_num);
		
		if(dto.getB_pass().equals(b_pass)){
			url="/Board/checkSuccess.jsp";
		}else{
			url="/Board/BoardCheckPass.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
