package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myboard.dto.CommentDTO;
import com.myboard.mapper.BoardMapper;
import com.myboard.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired 
	private CommentMapper cmapper;
	@Autowired
	private BoardMapper bmapper; 
	
	
	// 추가
	// @Transactional은 Controller에 넣어주지 않음.
	// @Transactional을 사용하기 위해서는 설정을 해줘야하는 작업이 있음.
	@Transactional  // 밑에 있는 2개의 함수가 하나의 작업으로 이루어지게 만들어줌.(둘 중에 하나라도 오류가 나면 롤백시켜줌)
	@Override
	public void insert(CommentDTO comment) {
		bmapper.updateReplyCnt(comment.getBnum(), 1);  //댓글 추가 후 replyCnt 증가
		cmapper.insert(comment);  // 댓글추가
	}

	// 전체보기
	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	// 댓글 삭제
	@Transactional
	@Override
	public void delete(int cnum) {
		CommentDTO comment = cmapper.read(cnum);  // bnum을 cnum을 통해서 구해옴.
		// 댓글 수 감소
		bmapper.updateReplyCnt(comment.getBnum(), -1);  // 댓글에 대한 bnum을 구해와야함.
		cmapper.delete(cnum);
	}

}
