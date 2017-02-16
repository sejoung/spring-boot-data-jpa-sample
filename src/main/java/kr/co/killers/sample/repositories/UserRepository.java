package kr.co.killers.sample.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import kr.co.killers.sample.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	public User findByUserid(String userid);
}
