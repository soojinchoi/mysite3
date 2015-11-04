package com.bit2015.mysite3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2015.mysite3.service.BoardService;
import com.bit2015.mysite3.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list( Model model ){		
		List<BoardVo> list = boardService.getList();
		model.addAttribute("list", list);	
		return "/board/list";		
	}
	
	@RequestMapping("/view/{no}")
	public String view( @PathVariable("no")Long no, Model model){		
		BoardVo vo = boardService.view(no);
		model.addAttribute("vo",vo);		
		return "/board/view";
	}
	
	@RequestMapping("/write")
	public String writeForm(){
		return "/board/write";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String write(@ModelAttribute BoardVo vo){
		boardService.write(vo);
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
		BoardVo vo = boardService.view(no);
		model.addAttribute("vo",vo);
		return "/board/modify";
	}
	
	@RequestMapping("/modi")
	public String modify(@ModelAttribute BoardVo vo){
		boardService.modify(vo);
		return "redirect:/board/list";
	}
}


