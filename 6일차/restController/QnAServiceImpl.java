package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.QnADAO;
import com.ssafy.happyhouse.model.dto.QnA;

@Service
public class QnAServiceImpl implements QnAService{
	private QnADAO qnaDao;
	
	@Autowired
	public void setQnaDao(QnADAO qnaDao) {
		this.qnaDao = qnaDao;
	}
	
	
	@Override
	public boolean createQnA(QnA qna) {
		return qnaDao.insertQnA(qna)>0;
	}

	@Override
	public boolean deleteQnA(int no) {
		return qnaDao.deleteQnA(no) > 0;
	}

	@Override
	public boolean updateQnA(QnA qna) {
		return qnaDao.updateQnA(qna)>0;
	}

	@Override
	public List<QnA> retrieveQnA() {
		return qnaDao.selectQnA();
	}

	@Override
	public QnA detailQnA(int no) {
		return qnaDao.selectQnAByNo(no);
	}

}
