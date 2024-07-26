package com.goodee.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.app.member.MemberDTO;
import com.goodee.app.util.Pager;
import com.goodee.app.util.ProductCommentPager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	
	@PostMapping("commentUpdate")
	public String commentUpdate(ProductCommentDTO productCommentDTO, Model model) throws Exception{
		
		int result = service.commentUpdate(productCommentDTO);
		
		model.addAttribute("msg", result);
		
		return "commons/result";
	}
	
	@PostMapping("commentDelete")
	public String commentDelete(ProductCommentDTO productCommentDTO, Model model) throws Exception{
		
		int result = service.commentDelete(productCommentDTO);
		
		model.addAttribute("msg", result);
		
		return "commons/result";
	}
	
	
	
	@GetMapping("commentList")
	public void commentList(ProductCommentPager productCommentPager, Model model) throws Exception{
		
		List<ProductCommentDTO> list = service.commentList(productCommentPager);
		
		model.addAttribute("list", list);
		model.addAttribute("pager", productCommentPager);
		
	}
	
	@PostMapping("commentAdd")
	public String commentAdd(ProductCommentDTO productCommentDTO, HttpSession session, Model model) throws Exception{
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("dto");
		productCommentDTO.setBoard_writer(memberDTO.getUser_id());
		
		int result = service.commentAdd(productCommentDTO);
		
		model.addAttribute("msg", result);
		
		return "commons/result";
	}
	
	
	@GetMapping("addWish")
	public String addWish(Long product_num, HttpSession session, Model model) throws Exception{
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("dto");
		
		int result = service.addWish(product_num, memberDTO.getUser_id());
		
		model.addAttribute("msg", result);
		
		return "commons/result";
	}
	
	@GetMapping("deleteWishList")
	public String deleteWishList(HttpSession session, Long[] product_num, Model model) throws Exception{
		
		for(Long p : product_num) {
			System.out.println(p);
		}
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("dto");
		
		int result = service.deleteWishList(product_num, memberDTO.getUser_id());
		
		model.addAttribute("msg", result);
		
		return "commons/result";
	}
	
	@GetMapping("wishList")
	public void wishList(HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("dto");
		List<ProductDTO> list = service.wishList(memberDTO);
		model.addAttribute("list", list);
	}
	
	@RequestMapping("list")
	public void getList(Model model, Pager pager ) throws Exception{
		List<ProductDTO> list = service.getList(pager);
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", list);
	}
	
	@RequestMapping("detail")
	public String getDetail(Model model, ProductDTO dto) throws Exception{
		ProductDTO dto2 = service.getDetail(dto);
		
		String path = "commons/message";
		if(dto2 != null) {
			model.addAttribute("dto", dto2);
			path = "product/detail";
		}else {
			model.addAttribute("result", "해당 데이터를 찾을 수 없습니다.");
			model.addAttribute("url", "/product/list");
		}
		
		return path;
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception{
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, ProductDTO dto, MultipartFile[] files, HttpSession session) throws Exception{
		int result = service.add(dto, files, session);
		
		String path = "commons/message";
		
		if(result > 0) {
			path = "redirect:/product/list";
		} else {
			model.addAttribute("result", "데이터 추가에 실패하였습니다.");
			model.addAttribute("url", "/product/list");
		}
		return path;
	}
	
	@RequestMapping("delete")
	public String delete(Model model, ProductDTO dto) throws Exception{
		int result = service.delete(dto);
		
		String path = "commons/message";
		
		if(result > 0) {
			path = "redirect:/product/list";
		}else {
			model.addAttribute("result", "데이터 삭제에 실패하였습니다.");
			model.addAttribute("url", "/product/list");
		}
		
		return path;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(Model model, ProductDTO dto) throws Exception{
		ProductDTO dto2 = service.getDetail(dto);
		
		String path = "commons/message";
		if(dto2 != null) {
			model.addAttribute("dto", dto2);
			path = "product/update";
		}else {
			model.addAttribute("result", "데이터 삭제에 실패하였습니다.");
			model.addAttribute("url", "/product/list");
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO dto) throws Exception{
		int result = service.update(dto);
		
		return "redirect:/product/list";
	}
}
