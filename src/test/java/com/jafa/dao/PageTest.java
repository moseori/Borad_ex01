package com.jafa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jafa.config.RootConfig;
import com.jafa.dto.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class PageTest {
	
	@Autowired
	BoardMapper mapper;

	@Test
	public void insertTest() {
		
		for (int i = 1; i <= 412 ; i++) {
			Board board=new Board();
			board.setTitle("제목 : 스프링 중입니다."+i);
			board.setContents("내용 : 스프링 중입니다."+i);
			board.setWriter("글쓴이"+i);
			mapper.insert(board);
			
		}
	}

}
