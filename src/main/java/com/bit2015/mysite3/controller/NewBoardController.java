package com.bit2015.mysite3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2015.mysite3.service.NewBoardService;
import com.bit2015.mysite3.vo.NewBoardVo;

@Controller
@RequestMapping("/board")
public class NewBoardController {
	
	@Autowired
	NewBoardService boardService;
	
	@RequestMapping("/list")
	public String list( Model model ){		
		List<NewBoardVo> list = boardService.getList();
		model.addAttribute("list", list);	
		return "/board/list";		
	}
	
	@RequestMapping("/view/{no}")
	public String view( @PathVariable("no")Long no, Model model){		
		NewBoardVo vo = boardService.view(no);
		model.addAttribute("vo",vo);	
		System.out.println(vo);
		return "/board/view";
	}
	
	@RequestMapping("/write")
	public String writeForm(){
		return "/board/write";
	}
	
	@RequestMapping("/writereply/{groupNo}&{orderNo}&{depth}")
	public String writeReplyForm(@ModelAttribute NewBoardVo vo,Model model){
		model.addAttribute("vo", vo );
		System.out.println(vo);
		return "/board/write";
	}
	@RequestMapping("/insert")
	public String write(@ModelAttribute NewBoardVo vo) {
		boardService.write(vo);
		System.out.println(vo);
		return "redirect:/board/list";
	}

	@RequestMapping("/delete/{no}")
	public String delete( @PathVariable("no") Long no, Model model){
		boardService.delete(no);
		model.addAttribute( "no", no );
		return "redirect:/board/list";
	}
	
	@RequestMapping("/modifyform/{no}")
	public String modifyForm(@PathVariable("no") Long no, Model model){
		NewBoardVo vo = boardService.view(no);
		model.addAttribute("vo",vo);
		return "/board/modify";
	}
	
	@RequestMapping("/modi")
	public String modify(@ModelAttribute NewBoardVo vo){
		boardService.modify(vo);
		return "redirect:/board/list";
	}
}


