package kr.co.killers.sample.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name="TB_COMMENT")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 1000, nullable = false)
	private String contents;

	@JsonIgnore
	@ManyToOne
	private Board board;
	
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
	}

	@PreUpdate
	public void preUpdate() {
		this.setUpdateDate(LocalDateTime.now());
	}
}
