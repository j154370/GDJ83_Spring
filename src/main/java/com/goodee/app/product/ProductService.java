package com.goodee.app.product;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.app.files.FileManager;
import com.goodee.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	@Autowired
	private FileManager fileManager;
	
	private String name="products";
	
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
		
		
		// 2~3은 fileManager 클래스 호출
		for(MultipartFile f : files) {	
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
			
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
