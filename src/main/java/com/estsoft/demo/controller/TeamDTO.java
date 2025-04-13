package com.estsoft.demo.controller;

import com.estsoft.demo.repository.Team;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDTO {
    private Long id;
    private String name;
    private List<MemberDTO> members;

    // 모든 필드 포함
    public TeamDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.members = team.getMembers().stream()
                .map(MemberDTO::new)
                .collect(Collectors.toList());
    }

    // ✅ 멤버 없이 생성하는 생성자 추가
    public TeamDTO(Team team, boolean includeMembers) {
        this.id = team.getId();
        this.name = team.getName();
        if (includeMembers && team.getMembers() != null) {
            this.members = team.getMembers().stream()
                    .map(MemberDTO::new)
                    .collect(Collectors.toList());
        }
    }
}