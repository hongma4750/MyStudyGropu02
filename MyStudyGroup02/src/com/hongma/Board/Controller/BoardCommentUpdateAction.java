package com.hongma.Board.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongma.Board.BEAN.CommentDAO;
import com.hongma.Board.BEAN.CommentVO;

public class BoardCommentUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request
		int com_seq = Integer.parseInt(request.getParameter("com_seq"));
		int com_ref = Integer.parseInt(request.getParameter("com_ref"));
		int com_step = Integer.parseInt(request.getParameter("com_step"));
		int com_depth = Integer.parseInt(request.getParameter("com_depth"));
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		String com_content=request.getParameter("com_content");
		
		
		//dao작업
		
		CommentVO vo = new CommentVO();
		vo.setCom_seq(com_seq);
		vo.setCom_ref(com_ref);
		vo.setCom_step(com_step);
		vo.setCom_depth(com_depth);
		vo.setCom_content(com_content);
		
		CommentDAO dao = CommentDAO.getInstance();
		dao.updateComment(vo);
		
		new BoardDetail(vo.getB_num()+"").execute(request, response);
		
		
	}

}
