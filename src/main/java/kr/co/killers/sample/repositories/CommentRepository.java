package kr.co.killers.sample.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import kr.co.killers.sample.domain.Comment;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long>{

}
