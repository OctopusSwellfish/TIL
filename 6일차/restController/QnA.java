package com.ssafy.happyhouse.model.dto;

import java.util.Date;

public class QnA {
	private int no;
	private String writer;
	private String title;
	private String content;
	private Date regtime;
	
	public QnA() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QnA [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content + ", regtime="
				+ regtime + "]";
	}

	public QnA(int no, String writer, String title, String content, Date regtime) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
	}

	public QnA(int no, String writer, String title, String content) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	
	
}
