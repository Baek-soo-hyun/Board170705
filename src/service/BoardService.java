package service;

import domain.BoardBean;

public interface BoardService {
	public void writeBoard(BoardBean board);
	public BoardBean[] list();
	public BoardBean findBySeq(int seq);
	public BoardBean[] findByWriter(String writer);
	public int countBoard();
	public void updateContent(BoardBean board);
	public void deleteBoard(int seq);
}
