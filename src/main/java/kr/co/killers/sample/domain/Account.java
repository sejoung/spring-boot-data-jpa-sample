package kr.co.killers.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import kr.co.killers.sample.constants.Role;
import lombok.Data;

@Data
@Entity(name = "TB_USER")
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50, unique=true)
	private String userid;
	
	@Column(length = 50, nullable = false)
	private String password;

	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(length = 50, nullable = false)
	private String nick;

}
