package com.goodee.app.product;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public List<ProductDTO> getList(Pager pager) throws Exception{

		pager.makeRow();
		
		long totalCount = dao.getTotalCount(pager);
		
		pager.makeNum(totalCount);
		
		return dao.getList(pager);
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		return dao.getDetail(dto);
	}
	
	public int add(ProductDTO dto, MultipartFile[] files, HttpSession session) throws Exception{
		
		Long num = dao.getNum();
		
		dto.setProduct_num(num);
		
		int result = dao.add(dto);
		
		
		if(files == null) {
			return result;
		}
		
		// 1. 저장할 폴더 지정
		ServletContext servletContext = session.getServletContext();
		
		String path = servletContext.getRealPath("resources/upload/products");
		System.out.println(path);
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 2. 저장할 파일명 생성
		for(MultipartFile f : files) {	
			if(f.isEmpty()) {
				continue;
			}
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + "_" + f.getOriginalFilename();
			
			// 3. HDD에 파일 저장
			File f2 = new File(file, fileName);
			f.transferTo(f2);
			
			// 4. 파일 정보 db에 저장
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setFile_name(fileName);
			productFileDTO.setOri_name(f.getOriginalFilename());
			productFileDTO.setProduct_num(num);
			result = dao.addFile(productFileDTO);
		}
		
		
		return result;
	}
	
	public int delete(ProductDTO dto) throws Exception{
		return dao.delete(dto);
	}
	
	public int update(ProductDTO dto) throws Exception{
		return dao.update(dto);
	}
}
