package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.DataSourceTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		cri.setPageNum(2);
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		cri.setAmount(20);
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(board -> {
			log.info(board);
		});
		//458764 ~ 458745 1page
		
		boardMapper.getListWithPaging(cri);
	}
	
	@Test
	public void testTotal() {
		log.info(boardMapper.getTotalCount(new Criteria()));
	}
	
	@Test
	public void testGetList() {
		boardMapper.getList().forEach(board -> log.info(board));
//		for(BoardVO board : boardMapper.getList()) {
//			log.info(board);
//		}
	}
	
	@Test
	public void testRead() {
		BoardVO board = boardMapper.read(1L);
		log.info("================================");
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		int cnt = boardMapper.delete(2L);
		log.info("========================================");
		log.info("delete cnt : " + cnt);
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setContent("수정된 내용");
		board.setTitle("수정된 제목");
		board.setWriter("user00");
		int cnt = boardMapper.update(board);
		log.info("update count : " + cnt);
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글2");
		board.setContent("새로 작성하는 내용2");
		board.setWriter("user02");
		
		//boardMapper.insert(board);
		boardMapper.insertSelectKey(board);
		
		log.info(board);
	}
}
