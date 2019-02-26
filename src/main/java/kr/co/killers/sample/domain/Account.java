package kr.co.killers.sample.domain;

import kr.co.killers.sample.constants.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
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
