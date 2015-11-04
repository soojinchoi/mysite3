package com.bit2015.mysite3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2015.mysite3.dao.GuestbookDao;
import com.bit2015.mysite3.service.GuestbookService;
import com.bit2015.mysite3.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
	GuestbookDao dao;
	
	@Autowired
	GuestbookService guestbookService;

	@RequestMapping("/index")
	public String index( Model model ) {
		List<GuestbookVo> list = guestbookService.getList();
		model.addAttribute( "list", list );
		return "/guestbook/index";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST )
	public String insert( @ModelAttribute GuestbookVo vo ) {
		System.out.println(vo);
		guestbookService.insert(vo);
		return "redirect:/guestbook/index";
	}
	
	@RequestMapping( "/deleteform/{no}" )
	public String deleteform( @PathVariable( "no" ) Long no, Model model ) {
		model.addAttribute( "no", no );
		System.out.println(no);
		return "/guestbook/deleteform";
	}
	
	@RequestMapping( "/delete" )
	public String delete( @ModelAttribute GuestbookVo vo ) {
		System.out.println(vo);
		guestbookService.delete(vo);
		return "redirect:/guestbook/index";
	}	
}