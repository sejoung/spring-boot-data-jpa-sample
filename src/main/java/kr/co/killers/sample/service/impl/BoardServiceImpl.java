package kr.co.killers.sample.service.impl;

import kr.co.killers.sample.param.BoardDetailParam;
import lombok.extern.slf4j.Slf4j;
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

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
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
	public Board detail(BoardDetailParam BoardDetailParam) {
		Optional<Board> bdo = boardRepository.findById(BoardDetailParam.getBoardId());
		Board result = null;

		if(bdo.isPresent()){
			Board bd = bdo.get();
			bd.setHit(bd.getHit() + 1);
			result = boardRepository.save(bd);
		}
		return result;
	}

	@Override
	public void delete(BoardParam boardParam) {
		boardRepository.deleteById(boardParam.getBoardId());
	}

	@Override
	public Page<Board> list(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Override
	public Board update(BoardParam boardParam) {
		Optional<Board> bdo = boardRepository.findById(boardParam.getBoardId());
		Board bd = bdo.orElse(new Board());
		bd.setTitle(boardParam.getBoardTitle());
		bd.setContents(boardParam.getBoardContents());
		bd.setUpdateUser(boardParam.getUser());
		return boardRepository.save(bd);
	}

	@Override
	public Board commentSave(CommentParam commentParam) {
		Board bd = boardRepository.findById(commentParam.getBoardId()).orElseThrow(()-> new EntityNotFoundException());
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
		commentRepository.deleteById(commentParam.getCommentId());
	}
	
}
