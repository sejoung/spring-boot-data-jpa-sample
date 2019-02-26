package kr.co.killers.sample.service;

import kr.co.killers.sample.param.BoardDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.co.killers.sample.domain.Board;
import kr.co.killers.sample.param.BoardParam;
import kr.co.killers.sample.param.CommentParam;

public interface BoardService {

	public Board save(BoardParam boardParam);

	public Board detail(BoardDetailParam boardDetailParam);

	public void delete(BoardParam boardParam);

	public Page<Board> list(Pageable pageable);

	public Board update(BoardParam boardParam);

	public Board commentSave(CommentParam commentParam);

	public void commentDelete(CommentParam commentParam);
	
}
