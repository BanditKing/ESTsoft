package com.estsoft.demo.controller;

import com.estsoft.demo.repository.Member;
import com.estsoft.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @ResponseBody
    @GetMapping("/members")
    public List<MemberDTO> showMembers() {
        List<Member> memberAll = memberService.getMemberAll();

        return memberAll.stream().map(member -> new MemberDTO(member)).toList();
    }
    @ResponseBody
    @PostMapping("/members")
    public Member saveMember(@RequestBody Member member) {
        return memberService.insertMember(member);
    }

    @GetMapping("hi")
    public String htmlPage(){

        return "hi"; //hi.html
    }

    // GET /members/{id} -> member 단건 조회
    @ResponseBody
    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    // DELETE /members/{id} -> member 단건 삭제
    @ResponseBody
    @DeleteMapping("/members/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMemberById(id);
        return "삭제 성공";
    }

    // GET /search? name=?

    @ResponseBody
    @GetMapping("/search/members")
    public List<Member> selectMemberByName(@RequestParam("name") String name) {
        return memberService.selectMemberByName(name);
    }
}
