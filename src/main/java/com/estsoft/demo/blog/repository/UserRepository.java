package com.estsoft.demo.blog.repository;

import com.estsoft.demo.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // 로그인 시 필요할 수도 있어요
}
