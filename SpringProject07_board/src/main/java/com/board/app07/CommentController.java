package com.board.app07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.CommentDTO;
import com.myboard.model.CommentService;



@RequestMapping("/reply/*")  // ��Ʈ�ѷ��� ��ü������ ����Ǵ� ���� @RequestMapping�� ���� ���´�.
//@Controller
@RestController  // @Controller + @ResponseBody -> @ResponseBody���� �� �޾����ٸ� @RestController�� ������ָ� ��
public class CommentController {

	@Autowired
	private CommentService cservice;
	
	// ����߰�
	@PostMapping("commentInsert")
	//@ResponseBody  // ���ڿ��� �������ֱ� ���ؼ� ���
	public String insert(@RequestBody CommentDTO comment) {  // @RequestBody : ���̽� ���·� ���� �ޱ� ������ ���
		cservice.insert(comment);
		return "success";
	}
	
//	// ��� ��ü����
//	@GetMapping("commentList")
//	//@ResponseBody   // �����ϴ� ���� view�� �ƴϱ� ������ �ݵ�� ���������.
//	public List<CommentDTO> getList(int bnum) {  // ���̽� ������ ���ڿ��� �ν���.
//		return cservice.getList(bnum);  // �ݹ��.
//	}
	
	@GetMapping("commentList/{bnum}") 
	public List<CommentDTO> getList(@PathVariable int bnum){  // @PathVariable: bnum�� ���� �޾ƿ��� ���� ���
		return cservice.getList(bnum);
	}
	
	// ��ۻ���
	@DeleteMapping("delete/{cnum}")
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;  // ��۹�ȣ�� ��ȯ�ϱ� ���ؼ� ��ȯ���� int�� ����.
	}
}
