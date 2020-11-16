package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.QnA;
import com.ssafy.happyhouse.model.dto.Result;
import com.ssafy.happyhouse.model.service.QnAService;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/vue/api/qna")
public class QnAController {
	
	private QnAService qnaService;
	
	@Autowired
	public void setQnaService(QnAService qnaService) {
		this.qnaService = qnaService;
	}
	
	@PostMapping
	public Result write(@RequestBody QnA qna) {
		System.out.println("로그당(등록)");
		boolean flag = qnaService.createQnA(qna);
		return new Result(flag);
	}
	@GetMapping
	public List<QnA> showAll() {
		System.out.println("로그당전체");
		return qnaService.retrieveQnA();
	}
	
	@GetMapping("/{no}")
	public Result getQnA(@PathVariable String no) {
		System.out.println("번호로하나만");
		QnA q = qnaService.detailQnA(Integer.parseInt(no));
		if(q!=null) {
			System.out.println(q.toString());
			return new Result(true, qnaService.detailQnA(Integer.parseInt(no)));			
		}
		return new Result(false);
	}
	
	@DeleteMapping("/{no}")
	public Result deleteQnA(@PathVariable String no) {
		System.out.println("찌워서");
		return new Result(true, qnaService.deleteQnA(Integer.parseInt(no)));
	}
	
	@PutMapping("/{no}")
	public boolean updateQnA(@RequestBody QnA qna) {
		System.out.println("?S?S?S?S?");
		System.out.println(qna.toString());
		return qnaService.updateQnA(qna);
	}
	
	
}
