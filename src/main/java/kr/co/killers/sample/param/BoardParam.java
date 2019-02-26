package kr.co.killers.sample.param;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class BoardParam {

	private Long boardId;
	
	@NotNull
	private String boardTitle;
	
	@NotNull
	@Size(min = 1, max = 1000)
	private String boardContents;
	
	private String user;

}
