package kr.co.killers.sample.domain;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
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
	
	@OneToMany(orphanRemoval = true, mappedBy = "board", fetch = FetchType.LAZY )
	private List<Comment> comments;
	
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
		this.comments.add(comment);
	}
}
