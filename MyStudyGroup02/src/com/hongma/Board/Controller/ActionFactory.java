package com.hongma.Board.Controller;

public class ActionFactory {
  
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){
		super();
	}
	
	public static ActionFactory getInstance(){
		return instance;
		
	}
	
	public Action getAction(String command){
		Action action = null;
		System.out.println("ActionFactory : "+command);
		
		if(command.equals("board_list")){
			action = new BoardListAction();
		}else if(command.equals("board_write")){
			action = new BoardWriteAction();
		}else if(command.equals("board_write_af")){
			action = new BoardWriteAFAction();
		}else if(command.equals("board_detail")){
			action = new BoardDetail();
		}else if(command.equals("body")){
			action = new BodyAction();
		}else if(command.equals("board_check_pass_form")){
			action = new BoardCheckPassFormAction();
		}else if(command.equals("board_check_pass")){
			action = new BoardCheckPassAction();
		}else if(command.equals("board_update_form")){
			action = new BoardUpdateFormAction();
		}else if(command.equals("board_update")){
			action = new BoardUpdateAction();
		}else if(command.equals("board_delete")){
			action = new BoardDeleteAction();
		}else if(command.equals("board_find")){
			action = new BoardFindAction();
		}else if(command.equals("board_answer")){
			action = new BoardAnswerAction();
		}else if(command.equals("board_answer_af")){
			action = new BoardAnswerFormAction();
		}else if(command.equals("board_comment_write")){
			action = new BoardCommentWriteAction();
		}else if(command.equals("board_comment_update")){
			action = new BoardCommentUpdateAction();
		}else if(command.equals("board_comment_delete")){
			action = new BoardCommentDeleteAction();
		}
		return action;
	}
}
