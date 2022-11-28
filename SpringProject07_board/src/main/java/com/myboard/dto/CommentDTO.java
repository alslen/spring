package com.myboard.dto;

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
	@JsonFormat(shape=Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul") // @JsonFormat : JSON 응답값의 형식을 지정할 때 사용한다.
	private Date regdate;  // regdate의 값은 yyyy-MM-dd이 형태로 나타내주기 위해 사용
	private int bnum;  // board테이블과 연관 외래키
}
