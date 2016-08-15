package com.hongma.Board.Controller;

public class Arrow {

	private int b_depth;

	public int getB_depth() {
		return b_depth;
	}

	public void setB_depth(int b_depth) {
		this.b_depth = b_depth;
	}
	
	public String getArrow(){				//답변 글 용도!!!
		String rs="<img src='img/arrow.png' style='width:20px; height:20px;'>";	
		String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
		String ts="";
		
		for(int i=0;i<b_depth;i++){
			ts += nbsp;
		}
		ts += rs;
		return b_depth==0? "":ts;
	}
}
