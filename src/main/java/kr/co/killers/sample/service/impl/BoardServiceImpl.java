package kr.co.killers.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.killers.sample.domain.Board;
import kr.co.killers.sample.domain.Comment;
import kr.co.killers.sample.param.BoardParam;
import kr.co.killers.sample.param.CommentParam;
import kr.co.killers.sample.repositories.BoardRepository;
import kr.co.killers.sample.repositories.CommentRepository;
import kr.co.killers.sample.service.BoardService;

@Service("boardService")
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Board save(BoardParam boardParam) {
		Board bd = new Board();
		bd.setCreateUser(boardParam.getUser());
		bd.setUpdateUser(boardParam.getUser());		
		bd.setTitle(boardParam.getBoardTitle());
		bd.setContents(boardParam.getBoardContents());
		bd.setHit(0);
		return boardRepository.save(bd);
	}

	@Override
	public Board detail(BoardParam boardParam) {
		Board bd = boardRepository.findOne(boardParam.getBoardId());
		bd.setHit(bd.getHit() + 1);
		boardRepository.save(bd);
		return bd;
	}

	@Override
	public void delete(BoardParam boardParam) {
		boardRepository.delete(boardParam.getBoardId());
	}

	@Override
	public Page<Board> list(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Override
	public Board update(BoardParam boardParam) {
		Board bd = boardRepository.findOne(boardParam.getBoardId());
		bd.setTitle(boardParam.getBoardTitle());
		bd.setContents(boardParam.getBoardContents());
		bd.setUpdateUser(boardParam.getUser());
		return boardRepository.save(bd);
	}

	@Override
	public Board commentSave(CommentParam commentParam) {
		Board bd = boardRepository.findOne(commentParam.getBoardId());
		Comment co = new Comment();
		co.setCreateUser(commentParam.getUser());
		co.setUpdateUser(commentParam.getUser());
		co.setContents(commentParam.getCommentContents());
		co.setBoard(bd);
		commentRepository.save(co);
		return bd;
	}

	@Override
	public void commentDelete(CommentParam commentParam) {
		commentRepository.delete(commentParam.getCommentId());
	}
	
}
