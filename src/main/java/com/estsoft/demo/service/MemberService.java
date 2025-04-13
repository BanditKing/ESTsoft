package com.estsoft.demo.service;


import com.estsoft.demo.repository.Member;
import com.estsoft.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    //getMemberAll 멤버 정보를 모두 조회
    public List<Member> getMemberAll() {
        return memberRepository.findAll();

    }

    // member 테이블에 insert 쿼리
    public Member insertMember(Member member) {
        Member saveMember = memberRepository.save(member);
        return saveMember;
    }

    // id로 특정 멤버 조회
    public Member getMemberById(Long id) {
        Optional<Member> optMember = memberRepository.findById(id);
              return optMember.orElse(new Member());
    }

    public void deleteMemberById(Long id) {

        memberRepository.deleteById(id);
    }

    public List<Member> selectMemberByName(String name) {
        return memberRepository.findByNameContaining(name);
    }
}