package com.mysecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysecurity.dto.CommentDTO;
import com.mysecurity.mapper.BoardMapper;
import com.mysecurity.mapper.CommentMapper;

@Service
public class CommentService {

	@Autowired
	private CommentMapper cmapper;
	@Autowired 
	private BoardMapper bmapper;
	
	// 추가
	@Transactional
	public void insert(CommentDTO comment) {
		System.out.println("bnum : "+comment.getBnum());
		bmapper.updateReplyCnt(comment.getBnum(), 1);  // 해당 게시글(omment.getBnum())에 replyCnt 1 증가
		cmapper.insert(comment);
	}
	
	public List<CommentDTO> list(int bnum) {
		return cmapper.list(bnum);
	}
	public int getCount(int bnum) {
		return cmapper.getCount(bnum);
	}
	
	// 삭제
	@Transactional  // 일련의 작업으로 구성되어야하기 때문에 꼭 써줘야함.
	public void delete(int cnum) {
		CommentDTO comment = cmapper.read(cnum);
		bmapper.updateReplyCnt(comment.getBnum(), -1);  // 댓글을 감소시키지 위해 
		cmapper.delete(cnum);
	}
}
