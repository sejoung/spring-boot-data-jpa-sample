package kr.co.killers.sample.domain;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import lombok.Data;

@Data
public abstract class Common {
	
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
