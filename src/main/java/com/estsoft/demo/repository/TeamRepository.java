package com.estsoft.demo.repository;

import com.estsoft.demo.repository.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}