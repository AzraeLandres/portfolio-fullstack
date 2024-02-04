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

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private TagRepo tagRepo;

    public ProjectEntity saveDetails(ProjectEntity projectEntity) {
        return projectRepo.save(projectEntity);
    }


    public List<ProjectEntity> getAllProjects() {
        return projectRepo.findAllWithSkillsAndTags();
    }


    public List<ProjectEntity> getAllProjectsBySkills(Integer skillsId) {
        Optional<SkillEntity> skillEntityOptional = skillRepository.findById(skillsId);

        if (skillEntityOptional.isPresent()) {
            return projectRepo.findBySkills(skillEntityOptional.get());
        } else {
            return Collections.emptyList();
        }
    }


    public List<ProjectEntity> getCustom(Integer tagsId) {
        Optional<TagEntity> tagEntityOptional = tagRepo.findById(tagsId);
        if (tagEntityOptional.isPresent()) {
            return projectRepo.findByTags(tagEntityOptional.get());

        } else {
            return Collections.emptyList();
        }
    }


}
