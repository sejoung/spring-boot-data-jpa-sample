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
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
	
	@Column(nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createDate;

	@Column(nullable = false)
	private String createUser;
	
	@Column(nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updateDate;

	@Column(nullable = false)
	private String updateUser;
	
	@PrePersist
	public void prePersist() {
		DateTime now = DateTime.now();
		this.setCreateDate(now);
		this.setUpdateDate(now);
		this.setHit(0);
	}

	@PreUpdate
	public void preUpdate() {
		this.setUpdateDate(DateTime.now());
	}
}
