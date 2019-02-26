package kr.co.killers.sample.param;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class CommentParam {

	private Long boardId;
	
	private Long commentId;

	@NotNull
	@Size(min = 1, max = 1000)
	private String commentContents;
	
	private String user;

}
