package com.myboard.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data  // Getter, Setter을 다 아우르는 어노테이션
public class FileBoardDTO {

	// 번호, 제목, 저자, 내용, 이미지
	private int num;
	private String title;
	private String writer;
	private String content;
	private MultipartFile upload;  // file을 받아오기 위해서 MultipartFile로 선언해줘야함.
	
	private String fileImage;  // 파일명을 이용해서 화면에 출력하기 위해 선언
}
