package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper boardMapper;
	
	@Override
	public BoardVO get(Long bno) {
		log.info("getList......................");
		return boardMapper.read(bno);
	}
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList.................");
		return boardMapper.getList();
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}
	
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify .........................");
		return boardMapper.update(board) == 1;
	}
	
	@Override
	public void register(BoardVO board) {
		log.info("register................" + board);
		boardMapper.insertSelectKey(board);
	}
	
	@Override
	public boolean remove(Long bno) {
		log.info("remove .......................");
		return boardMapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		return boardMapper.getListWithPaging(cri);
	}
}
