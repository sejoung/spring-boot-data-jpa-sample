package kr.co.killers.sample.param;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BoardDetailParam {

	@NotNull
	private Long boardId;

}
