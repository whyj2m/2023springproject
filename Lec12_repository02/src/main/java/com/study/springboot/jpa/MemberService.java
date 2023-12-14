package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public void insert() {
		Member member;
		
		member = Member.builder().name("제이엠").email("whyjm@gmail.com").build();
		memberRepository.save(member);
		member = Member.builder().name("제이엠1").email("whyjm1@gmail.com").build();
		memberRepository.save(member);
		member = Member.builder().name("제이엠2").email("whyjm2@gmail.com").build();
		memberRepository.save(member);
		member = Member.builder().name("제이엠3").email("whyjm3@gmail.com").build();
		memberRepository.save(member);
	}
	
	public List<Member> selectAll() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> selectId(Long search) {
		Optional<Member> member = memberRepository.findById(search);
		return member;
	}
	
	public Optional<Member> selectName(String search) {
		Optional<Member> member = memberRepository.findByName(search);
		return member;
	}
	
	public Optional<Member> selectEmail(String search) {
		Optional<Member> member = memberRepository.findByEmail(search);
		return member;
	}
	
	public List<Member> selectNameLike(String search) {
		List<Member> member = memberRepository.findByNameLike(search);
		return member;
	}
	
	 public List<Member> selectNameLikeNameDesc(String search)  {
	    	List<Member> member = memberRepository.findByNameLikeOrderByNameDesc(search);
	        return member;
	    }

	
//	public List<Member> selectNameSort(String search, Sort sort) {
//		List<Member> member = memberRepository.findByNameSort(search, sort);
//		return member;
//	}
	
}
