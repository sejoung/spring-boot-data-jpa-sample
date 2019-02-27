package kr.co.killers.sample.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity(name = "TB_BOARD")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, nullable = false)
	private String title;

	@Column(length = 1000, nullable = false)
	private String contents;	
		
	@Column(nullable = false)
	private int hit;
	
	@OneToMany(orphanRemoval = true, mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Comment> comments = new ArrayList<>();

	@Column(nullable = true)
	private LocalDateTime createDate;

	@Column(nullable = true)
	private String createUser;
	
	@Column(nullable = true)
	private LocalDateTime updateDate;

	@Column(nullable = true)
	private String updateUser;
	
	@PrePersist
	public void prePersist() {
		LocalDateTime now = LocalDateTime.now();
		this.setCreateDate(now);
		this.setUpdateDate(now);
		this.setHit(0);
	}

	@PreUpdate
	public void preUpdate() {
		this.setUpdateDate(LocalDateTime.now());
	}

	public void addComments(Comment comment){
		comment.setBoard(this);
		this.comments.add(comment);
	}
}
