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
		}
		return action;
	}
}
