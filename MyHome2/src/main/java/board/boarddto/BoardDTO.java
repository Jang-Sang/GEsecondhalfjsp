package board.boarddto;

import java.sql.Date;

public class BoardDTO {

	private int seq;
	private int no;
	private String title;
	private String content;
	private String filename;
	private int hit;
	private Date logtime;
	
	//필요한 다른 테이블의 컬럼을 여기에 추가하여 사용하기도 한다.
	private String id; //작성자 아이디
	private String name; //작성자 이름
	
	
	
	public BoardDTO() {
		super();
	}
	
	

	public BoardDTO(int no, String title, String content, String filename) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.filename = filename;
	}
	
	
	public BoardDTO(int seq, int no, String title, String content, String filename, int hit, Date logtime, String id,
			String name) {
		super();
		this.seq = seq;
		this.no = no;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.hit = hit;
		this.logtime = logtime;
		this.id = id;
		this.name = name;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getLogtime() {
		return logtime;
	}

	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}
	
	
}
