package kr.co.killers.sample.param;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BoardParam {

	private Long boardId;
	
	@NotNull
	private String boardTitle;
	
	@NotNull
	@Size(min = 1, max = 1000)
	private String boardContents;
	
	private String user;

}
