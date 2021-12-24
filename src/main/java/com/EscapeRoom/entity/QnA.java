package com.EscapeRoom.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data					// 롬복
@Entity					// 이것을 통해 
@Builder				// 객체 자동 생성해주는 것.
@AllArgsConstructor		// 생성자를 만들어 준다.
@NoArgsConstructor		// 기본 생성자도 만들어 줘.
@Table(name = "qna")	// 메모테이블이 있다면 쓰고, 없으면 만들어준다.
public class QnA {
	
	@Id					// pk라고 알려준다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 어떤 식으로 들어올껀데 밑에께 오토 인크리먼트. pk면서 autoincrement가 잡혀있다는 뜻
	private Long qnaNo;
	
	private Long adminNo;
	
	private String qnaName;
	
	private String qnaTitle;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date qnaDate;
	
	private String qnaContents;
	
	private String qnaPassword;
	
	private String qnaStatus;
	
	private String qnaAnswer;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date qnaAnswerDate;
	
}
