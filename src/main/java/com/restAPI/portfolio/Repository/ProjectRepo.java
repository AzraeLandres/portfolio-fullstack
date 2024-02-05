package com.restAPI.portfolio.Repository;


import com.restAPI.portfolio.Entity.ProjectEntity;
import com.restAPI.portfolio.Entity.SkillEntity;

import com.restAPI.portfolio.Entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface ProjectRepo extends JpaRepository<ProjectEntity, Integer> {

 


@Query("SELECT p FROM ProjectEntity p JOIN FETCH p.skills JOIN FETCH p.tags")
    List<ProjectEntity> findAllWithSkillsAndTags();
}






