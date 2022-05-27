package com.jafa.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.dto.Board;
import com.jafa.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public String getBoardList(Model model) {
		List<Board> list=service.getList();
		model.addAttribute("list",list);
		return "board/list";
	}

	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String get(Long bno, Model model) {
		Board board=service.get(bno);
		model.addAttribute("board",board);
		return "board/get";
	}
	
	@PostMapping("/remove")
	public String delete(Long bno, RedirectAttributes rttr) {
		service.remove(bno);
		rttr.addFlashAttribute("message", bno+"번 삭제함");
		return "redirect:list";
	}
}
