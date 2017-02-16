package kr.co.killers.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "TB_USER")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50, unique=true)
	private String userid;
	
	@Column(length = 50, nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	private String role;

	@Column(length = 50, nullable = false)
	private String nick;

}
