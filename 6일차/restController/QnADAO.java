package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.QnA;

@Mapper
@Repository
public interface QnADAO {
	public List<QnA> selectQnA();
	public QnA selectQnAByNo(int no);
	public int insertQnA(QnA qna);
	public int updateQnA(QnA qna);
	public int deleteQnA(int no);
}
