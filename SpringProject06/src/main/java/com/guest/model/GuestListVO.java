package com.guest.model;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter // @Getter라는 어노테이션을 사용하면 직접 getter를 쓰지 않아도 자동으로 만들어줌
@AllArgsConstructor  // @AllArgsConstructor을 사용하면 생성자를 만들지 않아도 자동으로 만들어줌

public class GuestListVO {

	private List<GuestVO> arr;
	private int count;
	

}
