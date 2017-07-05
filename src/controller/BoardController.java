package controller;

import javax.swing.JOptionPane;

import domain.BoardBean;
import service.BoardService;
import serviceImpl.BoardServiceImpl;

public class BoardController {
	public static void main(String[] args) {
		BoardBean board = null;
		BoardService boardService = new BoardServiceImpl();
		int seq = 1;
				
		while(true) {
			switch(JOptionPane.showInputDialog("0.exit 1.writeBoard 2.list 3.findBySeq 4.findByWriter 5.countBoard 6.updatecontent 7.deleteBoard")) {
			case "0" :
				return;
			case "1" :
				board = new BoardBean();
				String[] arr = JOptionPane.showInputDialog("Writer/Title/Content/Regdate").split("/");
				board.setSeq(seq++);
				board.setWriter(arr[0]);
				board.setTitle(arr[1]);
				board.setContent(arr[2]);
				board.setRegdate(arr[3]);
				boardService.writeBoard(board);
				JOptionPane.showMessageDialog(null, "complete");
				break;
			case "2" :
				String result = "";
				BoardBean[] boardList = boardService.list();
				for (int i=0 ; i<boardService.countBoard() ; i++) {
					result += boardList[i];
				}
				JOptionPane.showMessageDialog(null, result);
				break;
			case "3" : 
				JOptionPane.showMessageDialog(null, boardService.findBySeq(Integer.parseInt(JOptionPane.showInputDialog("seq?"))).toString());
				break;
			case "4" :
				String result2 = "";
				for(int i=0 ; i<boardService.countBoard() ; i++) {
					result2 += boardService.findByWriter(JOptionPane.showInputDialog("writer?"))[i].toString();
				}
				JOptionPane.showInternalMessageDialog(null, result2);
				;
				break;
			case "5" :
				JOptionPane.showMessageDialog(null, boardService.countBoard());
				break;
			case "6" :
				board.setSeq(Integer.parseInt(JOptionPane.showInputDialog("seq?")));
				board.setContent(JOptionPane.showInputDialog("content?"));
				boardService.updateContent(board);
				JOptionPane.showMessageDialog(null, "변경 완료");
				break;
			case "7" :
				boardService.deleteBoard(Integer.parseInt(JOptionPane.showInputDialog("삭제할 seq?")));
				JOptionPane.showMessageDialog(null, "삭제 완료");
				break;
			}
		}
	}

}
