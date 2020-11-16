package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.QnA;

public interface QnAService {
	public boolean createQnA(QnA qna);
	public boolean deleteQnA(int no);
	public boolean updateQnA(QnA qna);
	public List<QnA> retrieveQnA();
	public QnA detailQnA(int no);
}
