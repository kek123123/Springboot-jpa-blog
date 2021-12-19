package com.shnam.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORM -> 자바 Object를 테이블로 매핑해주는 기술
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더패턴
@Entity // User 클래스가 MySQL에 테이블 생성
//@DynamicInsert // 인서트 시에 null인 필드를 제외
public class User {
	
	@Id//기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id;
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//DB는 roleType이 없기 때문에 어노테이션 사용
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다. (이넘을 쓰면 데이터의 도메인을 만들어줄 수 있다. 이넘을 사용하면 실수 방지)
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate; 
}
