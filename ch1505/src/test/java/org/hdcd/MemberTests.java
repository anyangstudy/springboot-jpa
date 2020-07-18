package org.hdcd;

import java.util.Optional;

import javax.transaction.Transactional;

import org.hdcd.domain.Member;
import org.hdcd.domain.MemberDetail;
import org.hdcd.repository.MemberDetailRepository;
import org.hdcd.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@Commit
@SpringBootTest
public class MemberTests {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberDetailRepository memberDetailRepository;
	
	@Test
	public void testRegister() {
		Member member1 = new Member();
		member1.setUserId("jupiter");
		member1.setUserPw("1234");
		
		memberRepository.save(member1);
		
		Member member2 = new Member();
		member2.setUserId("venus");
		member2.setUserPw("4567");
		
		memberRepository.save(member2);
		
		Member member3 = new Member();
		member3.setUserId("mercury");
		member3.setUserPw("9876");
		
		memberRepository.save(member3);
	}
	
	@Test
	public void testList() {
		Iterable<Member> members = memberRepository.findAll();
		
		for(Member member : members) {
			System.out.println(member);
		}
	}
	
	@Transactional
	@Test
	public void testRegisterWithDetailAtTransactional() {
		Member member1 = new Member();
		member1.setUserId("jupiter");
		member1.setUserPw("1234");
		
		MemberDetail memberDetail1 = new MemberDetail();
		memberDetail1.setUserName("Alex");
		memberDetail1.setEmail("jupiter@onnote.net");
		
		memberDetail1.setMember(member1);
		
		memberRepository.save(member1);
		
		memberDetailRepository.save(memberDetail1);
	}
	
	@Test
	public void testModify() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		
		if (memberOptional.isPresent()) {
			Member member = memberOptional.get();
			member.setUserPw("5678");
			
			memberRepository.save(member);
		}
	}
	
	@Test
	public void testRead() {
		Optional<Member> memberOptional = memberRepository.findById(1L);
		
		if (memberOptional.isPresent()){
			Member member = memberOptional.get();
			
			System.out.println(member);
		}
	}
	
	@Test
	public void testRemove_X() {
		memberRepository.deleteById(1L);
	}
	
	@Test
	public void testRemoveWithDetail() {
		memberDetailRepository.deleteById(1L);
		
		memberRepository.deleteById(1L);
	}
	
}
