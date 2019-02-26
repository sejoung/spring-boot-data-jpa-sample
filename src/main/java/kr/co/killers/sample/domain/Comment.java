package kr.co.killers.sample.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
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
