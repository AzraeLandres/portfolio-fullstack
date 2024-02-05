package com.restAPI.portfolio.Service;


import com.restAPI.portfolio.Entity.ProjectEntity;
import com.restAPI.portfolio.Entity.SkillEntity;
import com.restAPI.portfolio.Entity.TagEntity;
import com.restAPI.portfolio.Repository.ProjectRepo;
import com.restAPI.portfolio.Repository.SkillRepository;
import com.restAPI.portfolio.Repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    

    public ProjectEntity saveDetails(ProjectEntity projectEntity) {
        return projectRepo.save(projectEntity);
    }


    public List<ProjectEntity> getAllProjects() {
        return projectRepo.findAllWithSkillsAndTags();
    }




}
