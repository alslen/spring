package com.guest.model;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter // @Getter��� ������̼��� ����ϸ� ���� getter�� ���� �ʾƵ� �ڵ����� �������
@AllArgsConstructor  // @AllArgsConstructor�� ����ϸ� �����ڸ� ������ �ʾƵ� �ڵ����� �������

public class GuestListVO {

	private List<GuestVO> arr;
	private int count;
	

}
