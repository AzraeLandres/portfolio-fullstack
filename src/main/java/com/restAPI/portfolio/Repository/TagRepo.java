package com.restAPI.portfolio.Repository;

import com.restAPI.portfolio.Entity.ProjectEntity;
import com.restAPI.portfolio.Entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface TagRepo extends JpaRepository<TagEntity, Integer> {

 List<TagEntity> findByAssignedTags(ProjectEntity projectEntity);



}
