package com.board.app07;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.myboard.dto.FileBoardDTO;
import com.myboard.model.BoardService;

@Controller
public class FileController {
	@Autowired
	private BoardService bservice;

	@GetMapping("uploadFile")
	public String uploadFile() {
		
		return "uploadForm";
	}
	
	@PostMapping("fileAction")
	public String upload(MultipartFile[] uploads, Model model) { 
		// 업로드할 파일의 위치를 지정
		String uploadFolder="C:\\Users\\admin\\git\\spring\\SpringProject07_board\\src\\main\\webapp\\resources";
		ArrayList<String> arr = new ArrayList<String>();
		
		for(MultipartFile multipartFile : uploads) {
			// 파일 이름 중복 피하기 위해 이름 수정
			UUID uuid = UUID.randomUUID();  // 난수값을 발생
			String uploadFileName = uuid.toString()+"_"+multipartFile.getOriginalFilename();  // getOriginalFilename() : 파일이름을 구해옴.
			//System.out.println("uploadFileName : "+uploadFileName);
			// uploadFolder의 위치에 파일이름이 uploadFileName으로 객체를 생성한다.
			File saveFile = new File(uploadFolder, uploadFileName);
			try {
				multipartFile.transferTo(saveFile);  // 파일을 업로드 시킴
				arr.add(multipartFile.getOriginalFilename());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			model.addAttribute("uploadFileName", arr);
		}
		
		return "fileResult";
	}
	
	@GetMapping("fileInsert")
	public String fileInsert() {
		return "fileboardInsert";
	}
	
	@PostMapping("fileInsert")
	public String fileInsert(FileBoardDTO fboard, HttpSession session) { // HttpSession을 사용하는 이유는 파일 위치를 가져오기 위해
		// session.getServletContext().getRealPath("/") : webapp를 알려줌(프로젝트 안에서 폴더이동 가능)
		String uploadFolder = session.getServletContext().getRealPath("/") + "\\resources\\img";  
		//System.out.println("uploadFolder:"+uploadFolder);
		
		UUID uuid = UUID.randomUUID();  // 난수를 만듦(파일명의 중복을 피하고 싶어서)
		MultipartFile f = fboard.getUpload();
		String uploadFileName="";
		if(!f.isEmpty()) {  // 파일 업로드를 했다면
			uploadFileName = uuid.toString()+"_"+f.getOriginalFilename();
			File file = new File(uploadFolder, uploadFileName);  // 파일 객체 생성
			
			try {
				f.transferTo(file); // 파일업로드
				fboard.setFileImage(uploadFileName); // DB에 들어갈 파일 이름.
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		bservice.fileInsert(fboard);
		return "redirect:fileList";
	}
	@GetMapping("fileList")
	public String fileList() {
		return null;
	}
}
