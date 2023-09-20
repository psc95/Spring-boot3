package net.daum.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //getter()메서드 자동생성
@Setter //setter()메서드 자동생성
@ToString //ToString()메서드 자동생성
@Entity //JPA(Java Persistence API의 약어)를 다루는 엔티티 빈 클래스
@SequenceGenerator(//시퀀스 생성기를 설정하는 애너테이션
		 name = "bno_seq2_gename", //시퀀스 제너레이터 이름
		 sequenceName = "bno_seq2", //시퀀스 이름
		 initialValue = 1, //시퀀스 시작값
		 allocationSize = 1 //기본값이 50, 1씩 증가
		)
@Table(name = "tbl_boards2") //tbl_boards2 라는 테이블명을 지정
public class BoardVO {//JPA에서 사용하는 엔티티빈 클래스 => 이 클래스를 통해서 오라클 DB에 테이블과
	//시퀀스가 생성됨
	
	@Id //기본키 => 구분키
	@GeneratedValue(
			 strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
			 generator = "bno_seq2_gename" //시퀀스 제너레이터 이름 지정
			)
	private int bno; //게시판 번호
	private String writer; //작성자
	private String title; //글제목
	private String content; //글내용
	
	@CreationTimestamp //하이버 네이트의 특별한 기능으로 게시물 등록시점 날짜값을 기록
	private Timestamp regdate; //등록날짜
	
	@UpdateTimestamp //하이버 네이트의 특별한 기능으로 게시물 수정시점 날짜값을 기록
	private Timestamp updatedate; //수정날짜
}






