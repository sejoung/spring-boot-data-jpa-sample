package kr.co.killers.sample.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.co.killers.sample.domain.Account;

public class UserDetailsImpl extends User {

	private static final long serialVersionUID = 1L;

	private static String ROLE_PREFIX = "ROLE_";
	
	private String nick;
	
	private String role;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public UserDetailsImpl(Account account) {
		super(account.getUserid(), account.getPassword(), authorities(account));
		this.setNick(account.getNick());
		this.setRole(account.getRole().toString());
	}

	private static Collection<? extends GrantedAuthority> authorities(Account account) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + account.getRole().toString()));
		return authorities;
	}

}
