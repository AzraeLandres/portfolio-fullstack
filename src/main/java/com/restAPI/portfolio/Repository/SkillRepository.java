package com.restAPI.portfolio.Repository;

import com.restAPI.portfolio.Entity.ProjectEntity;
import com.restAPI.portfolio.Entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<SkillEntity, Integer> {


}
