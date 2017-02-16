package kr.co.killers.sample.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetailsImpl extends User {

	private static final long serialVersionUID = 1L;

	private String nick;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public UserDetailsImpl(kr.co.killers.sample.domain.User user) {
		super(user.getUserid(), user.getPassword(), authorities(user));
		this.nick = user.getNick(); 
	}

	private static Collection<? extends GrantedAuthority> authorities(kr.co.killers.sample.domain.User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return authorities;
	}

}
