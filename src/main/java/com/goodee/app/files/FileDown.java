package com.goodee.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDown extends AbstractView{
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

//		어떤 key값이 들어있는지 확인하는 코드
//		Iterator<String> keys = model.keySet().iterator();
//		
//		while(keys.hasNext()) {
//			String k = keys.next();
//			System.out.println(k);
//		}
		
		FileDTO fileDTO = (FileDTO)model.get("file");
		String directory = (String)model.get("board");
		
		// 1. 폴더 경로 준비
		String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + directory);
		
		// 2. 파일 준비
		File file = new File(path, fileDTO.getFile_name());
		
		// 3. 응답시 인코딩 처리(인코딩 처리를 이미 했다면 하지 않아도 됨)
		response.setCharacterEncoding("UTF-8");
		
		// 4. 파일의 크기 지정
		response.setContentLength((int)file.length());
		
		// 5. 다운로드시 파일 이름 지정, 인코딩 설정2
		String name = fileDTO.getOri_name();
		name = URLEncoder.encode(name, "UTF-8");
		
		// 6. Header 정보 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+name+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// 7. 클라이언트로 전송
		// HDD에서 파일을 읽어와서 클라이언트로 output 실행
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		// 8. 연결 해제
		os.close();
		fi.close();
		
	}
	
	

}
