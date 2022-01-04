package com.EscapeRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EscapeRoom.entity.PlayTime;


public interface PlayTimeRepository extends JpaRepository<PlayTime, Long> {
	// JpaRepository<QnA, Long> 
	// QnA에는 해당하는 테이블 명을 적는다. Long에는 그 테이블의 pk값(기본키값)의 데이터타입을 넣는다.
}
