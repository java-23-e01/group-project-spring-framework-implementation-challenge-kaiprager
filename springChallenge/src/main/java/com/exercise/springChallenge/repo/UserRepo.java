package com.exercise.springChallenge.repo;

import com.exercise.springChallenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
