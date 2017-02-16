package kr.co.killers.sample.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import kr.co.killers.sample.domain.Board;

public interface BoardRepository extends PagingAndSortingRepository<Board, Long>{
}
