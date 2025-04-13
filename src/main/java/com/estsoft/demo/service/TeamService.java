package com.estsoft.demo.service;

import com.estsoft.demo.repository.Team;
import com.estsoft.demo.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public List<Team> getAllTeams() {

        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {

        return teamRepository.findById(id);
    }
}