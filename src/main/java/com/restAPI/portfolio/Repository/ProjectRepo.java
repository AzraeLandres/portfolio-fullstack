package com.restAPI.portfolio.Repository;


import com.restAPI.portfolio.Entity.ProjectEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;



public interface ProjectRepo extends JpaRepository<ProjectEntity, Integer> {

 


@Query("SELECT p FROM ProjectEntity p JOIN FETCH p.skills JOIN FETCH p.tags")
    List<ProjectEntity> findAllWithSkillsAndTags();
}






