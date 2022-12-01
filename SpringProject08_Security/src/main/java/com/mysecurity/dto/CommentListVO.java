package com.mysecurity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor  // 모든 인자를 가지고 생성자를 만들어줌
public class CommentListVO {

	private List<CommentDTO> carr;
	private int count;
}
