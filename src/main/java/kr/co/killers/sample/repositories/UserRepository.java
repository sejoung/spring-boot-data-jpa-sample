package kr.co.killers.sample.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import kr.co.killers.sample.domain.Account;

public interface UserRepository extends PagingAndSortingRepository<Account, Long>{
	public Account findByUserid(String userid);
}
