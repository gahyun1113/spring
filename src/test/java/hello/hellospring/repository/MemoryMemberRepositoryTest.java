package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findbyId(member.getId()).get();
//        Assertions.assertEquals(member,result);

        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findbyName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //쉬프트 f6 리네임
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findbyName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //쉬프트 f6 리네임
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }
}
