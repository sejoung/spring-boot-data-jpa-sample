package kr.co.killers.sample.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "TB_BOARD")
public class Board  extends Common{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, nullable = false)
	private String title;

	@Column(length = 1000, nullable = false)
	private String contents;	
		
	@Column(nullable = false)
	private int hit;
	
	@OneToMany(orphanRemoval = true, mappedBy = "board", fetch = FetchType.LAZY )
	private List<Comment> comments;
	
	@PrePersist
	public void prePersist() {
		this.setHit(0);
	}
}
