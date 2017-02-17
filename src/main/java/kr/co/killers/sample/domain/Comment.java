package kr.co.killers.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
	}

	@PreUpdate
	public void preUpdate() {
		this.setUpdateDate(DateTime.now());
	}
}
