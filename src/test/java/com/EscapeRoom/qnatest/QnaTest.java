package com.EscapeRoom.qnatest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.EscapeRoom.entity.QnA;
import com.EscapeRoom.repository.QnaRepository;

@SpringBootTest
public class QnaTest {

	@Autowired
	QnaRepository qrepo;
	
	@Test
	public void insertTest() {
		
		QnA qna = new QnA();
		
		qna.setQnaNo(1L);
		
		qna.setQnaTitle("테스트타이틀");
		qna.setQnaName("테스트작성자");
		qna.setQnaContents("테스트 내용");
		qna.setQnaPassword("테스트비밀번호");
		
		qrepo.save(qna);
	}
	
}
