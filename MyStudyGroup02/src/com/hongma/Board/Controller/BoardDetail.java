package com.hongma.Board.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.BoardDAO;
import com.hongma.Board.BEAN.BoardDTO;
import com.hongma.Board.BEAN.CommentDAO;
import com.hongma.Board.BEAN.CommentVO;
  
public class BoardDetail implements Action{

	int b_num=0;
	public BoardDetail(String b_num) {
		this.b_num=Integer.parseInt(b_num);
	}
	
	public BoardDetail(){
		
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp?mode=Board/BoardDetail";
		
		String num = request.getParameter("b_num");
		int b_num = Integer.parseInt(num);
		
		BoardDAO bodao = BoardDAO.getInstance();
		bodao.updateReadCount(b_num);
		BoardDTO bodto = bodao.selectBoardDTO(b_num);
		
		CommentDAO comDao = CommentDAO.getInstance();
		List<CommentVO> comList = comDao.selectAllComment(b_num);
		
		
		
		request.setAttribute("board", bodto);
		request.setAttribute("comList", comList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
