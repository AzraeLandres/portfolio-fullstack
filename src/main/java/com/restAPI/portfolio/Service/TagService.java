package com.restAPI.portfolio.Service;

import com.restAPI.portfolio.Entity.ProjectEntity;
import com.restAPI.portfolio.Entity.TagEntity;
import com.restAPI.portfolio.Repository.ProjectRepo;
import com.restAPI.portfolio.Repository.TagRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TagService {


    private final ProjectRepo projectRepo;


    private final TagRepo tagRepo;

    public TagService(ProjectRepo projectRepo, TagRepo tagRepo) {
        this.projectRepo = projectRepo;
        this.tagRepo = tagRepo;
    }

    public List<TagEntity> getAllTags() {
    return tagRepo.findAll();
}

    public List<TagEntity> getTagsByProjectId(Integer projectId) {
        Optional<ProjectEntity> projectEntityOptional = projectRepo.findById(projectId);

        return projectEntityOptional.map(tagRepo::findByAssignedTags).orElse(null);
    }

    public List<TagEntity> getTagsByProject(ProjectEntity projectEntity) {
        return tagRepo.findByAssignedTags(projectEntity);
    }


}
