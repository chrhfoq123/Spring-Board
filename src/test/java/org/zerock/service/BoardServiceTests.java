package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapperTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글2");
		board.setContent("새로 작성하는 내용2");
		board.setWriter("user03");
		boardService.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
	}
	
	@Test
	public void testGetList() {
		boardService.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testGet() {
		log.info(boardService.get(22L));
	}
	
	@Test
	public void testDelete() {
		log.info(boardService.remove(10L));
	}
	
	@Test
	public void testModify() {
		BoardVO board = boardService.get(9L);
		if(board == null) return;
		board.setTitle("제목 수정합니다. 2");
		board.setContent("내용 수정합니다. 2");
		log.info("MODIFY RESULT : " + boardService.modify(board));
	}
}
