/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kr.co.killers.sample.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import kr.co.killers.sample.param.BoardDetailParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.killers.sample.domain.Board;
import kr.co.killers.sample.domain.Comment;
import kr.co.killers.sample.param.BoardParam;
import kr.co.killers.sample.param.CommentParam;
import kr.co.killers.sample.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list.do")
	public String list(Map<String, Object> model, @RequestParam(name = "page", defaultValue = "0", required = false) int page, @RequestParam(name = "pagesize", defaultValue = "10", required = false) int pagesize) {
		Page<Board> datas = boardService.list(PageRequest.of(page, pagesize, Direction.DESC, "id"));
		model.put("datas", datas);
		return "board.list";
	}

	@RequestMapping("/update.do")
	public String update(Map<String, Object> model, @Valid BoardParam boardParam) {
		Board bd = boardService.update(boardParam);
		model.put("bd", bd);
		return "board.boardUpForm";
	}

	@RequestMapping("/save.do")
	public String boardAdd(Map<String, Object> model, @Valid BoardParam boardParam) {
		boardService.save(boardParam);
		return "redirect:/board.do";
	}

	@RequestMapping("/detail.do")
	public String detail(Map<String, Object> model, @Valid BoardDetailParam boardDetailParam) {
		Board bd = boardService.detail(boardDetailParam);
		List<Comment> cList = bd.getComments();
		model.put("bd", bd);
		model.put("coList", cList);
		return "board.boardDetail";
	}

	@RequestMapping("/delete.do")
	public String delete(Map<String, Object> model, @Valid BoardParam boardParam)	{
		boardService.delete(boardParam);
		return "redirect:/board.do";
	}
	
	@RequestMapping("/boardCommentDelete.do")
	public String boardCommentDelete(Map<String, Object> model,@Valid CommentParam commentParam)	{
		boardService.commentDelete(commentParam);
		return "redirect:/board/detail.do?boardId="+commentParam.getBoardId();
	}

	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(Map<String, Object> model, @Valid BoardParam boardParam) {
		Board bd = boardService.update(boardParam);
		model.put("bd", bd);
		return "board.detail";
	}

	@RequestMapping("/CommentAdd.do")
	public String boardCommentAdd(Map<String, Object> model, @Valid CommentParam CommentAddParam) {
		boardService.commentSave(CommentAddParam);
		
		return "redirect:/board/detail.do?boardId=" + CommentAddParam.getBoardId();
	}

}
