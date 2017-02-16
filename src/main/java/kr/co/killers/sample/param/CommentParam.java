package kr.co.killers.sample.param;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CommentParam {

	private Long boardId;
	
	private Long commentId;

	@NotNull
	@Size(min = 1, max = 1000)
	private String commentContents;
	
	private String user;

}
