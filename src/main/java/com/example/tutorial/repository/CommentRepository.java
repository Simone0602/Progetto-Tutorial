package com.example.tutorial.repository;

import com.example.tutorial.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Integer> {
}
