package kr.co.killers.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.killers.sample.domain.Account;
import kr.co.killers.sample.repositories.UserRepository;
import kr.co.killers.sample.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		Account account = userRepository.findByUserid(userid);
		if (account == null) {
	            throw new UsernameNotFoundException(userid);
	    }
		return new UserDetailsImpl(account);
	}

}