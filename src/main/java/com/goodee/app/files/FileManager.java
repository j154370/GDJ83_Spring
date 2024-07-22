package com.goodee.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public String fileSave(String path, MultipartFile files) throws Exception{
		
		// 1. 저장할 폴더 지정
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}	
		
		// 2. 파일명은 어떻게 할 것인가 - (1)라이브러리 사용

		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + files.getOriginalFilename();

		// 3. HDD에 파일을 저장하는 단계 - (1)MultipartFile 사용
		file = new File(file, fileName);

		files.transferTo(file);
		
		return fileName;

	}

}
