package domain;

public class BoardBean {
	private int seq;
	private String writer, title, content, regdate;  
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getSeq() {
		return seq;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriter() {
		return writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getRegdate() {
		return regdate;
	}
	public String toString() {
		return "[seq : " + seq + ", writer : " + writer + ", title : " + title + ", content : " + content + ", regdate : " + regdate + "] \n";
	}
	

}
