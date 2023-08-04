package com.example.tutorial.repository;

import com.example.tutorial.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

    List<Tutorial> findByPublished(boolean published);

}
