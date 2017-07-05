package serviceImpl;

import domain.BoardBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{

	int count;
	BoardBean board;
	BoardBean[] boardList;
	public BoardServiceImpl() {
		count = 0;
		board = new BoardBean();
		boardList = new BoardBean[count];
	}

	@Override
	public void writeBoard(BoardBean board) {
		if(count==boardList.length) {
			BoardBean[] temp = new BoardBean[count+1];
			System.arraycopy(boardList, 0, temp, 0, count);
			boardList = temp;
		}
		boardList[count] = board;
		count++;
	}

	@Override
	public BoardBean[] list() {
		return boardList;
	}

	@Override
	public BoardBean findBySeq(int seq) {
		for(int i = 0 ; i < boardList.length ; i++) {
			if (seq == boardList[i].getSeq()) {
				board = boardList[i];
				break;
			}
		}
		return board;
	}

	@Override
	public BoardBean[] findByWriter(String writer) {
		int countFind = 0;
		
		for(int i = 0 ; i < boardList.length ; i++) {
			if(writer.equals(boardList[i])) {
				countFind++;
			}
		}
		int j = 0;
		BoardBean[] findList = new BoardBean[countFind];
		for(int i = 0 ; i < boardList.length ; i++) {
			if(writer.equals(boardList[i])) {
				boardList[i] = findList[j];
				j++;
			}
		}
		return findList;
	}

	@Override
	public int countBoard() {
		return count;
	}

	@Override
	public void updateContent(BoardBean board) {
		findBySeq(board.getSeq()).setContent(board.getContent());
	}

	@Override
	public void deleteBoard(int seq) {
		for(int i = 0 ; i < boardList.length ; i++) {
			if(seq == boardList[i].getSeq()) {
				boardList[i] = boardList[count-1];
				break;
			}
		}
		boardList[count-1] = null;
		count--;
	}
	
}
