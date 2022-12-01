package com.mysecurity.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentDTO {

	private int cnum;
	private String userid;
	private String content;
	@JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul") // 날짜도 JSON형태로 받아오기 때문에 보기 불편함. 
																				//-> JSONFormat이라는 어노테이션을 사용해서 우리가 원하는 날짜 형태로 바뀔 수 있음
	private Date regdate;
	private int bnum;
}
