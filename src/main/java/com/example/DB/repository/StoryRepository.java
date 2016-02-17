package com.example.DB.repository;

import com.example.DB.domain.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<Story, String> {

    public List<Story> findAll();
}
