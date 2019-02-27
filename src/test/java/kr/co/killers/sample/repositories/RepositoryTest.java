package kr.co.killers.sample.repositories;

import kr.co.killers.sample.domain.Board;
import kr.co.killers.sample.domain.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {


    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void contextLoad(){

        Board b = new Board();

        b.setContents("a");
        b.setHit(0);
        LocalDateTime now = LocalDateTime.now();
        b.setCreateDate(now);
        b.setTitle("타이틀");
        b.setCreateUser("나다");
        boardRepository.save(b);
        Comment c = new Comment();
        c.setContents("aaa");
        b.addComments(c);

        commentRepository.save(c);


        commentRepository.findAll().forEach((comment) ->{

            System.out.println("aaa "+comment.getBoard().getId());
            System.out.println("aaa "+comment.getContents());

        });





    }

}
