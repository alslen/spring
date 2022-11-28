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
	@JsonFormat(shape=Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul") // @JsonFormat : JSON ���䰪�� ������ ������ �� ����Ѵ�.
	private Date regdate;  // regdate�� ���� yyyy-MM-dd�� ���·� ��Ÿ���ֱ� ���� ���
	private int bnum;  // board���̺��� ���� �ܷ�Ű
}