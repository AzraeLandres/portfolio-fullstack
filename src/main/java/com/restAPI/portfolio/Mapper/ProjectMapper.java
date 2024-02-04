package com.restAPI.portfolio.Mapper;

import java.util.stream.Collectors;

import com.restAPI.portfolio.DTO.ProjectDto;
import com.restAPI.portfolio.Entity.ProjectEntity;

public class ProjectMapper {
    
    public static ProjectDto mapToDto(ProjectEntity projectEntity) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(projectEntity.getId());
        projectDto.setName(projectEntity.getName());
        projectDto.setAbout(projectEntity.getAbout());
        projectDto.setLink(projectEntity.getLink());

        if (projectEntity.getSkills() != null) {
            projectDto.setSkills(projectEntity.getSkills().stream().map(SkillMapper::mapToDto).collect(Collectors.toSet()));              
        }

        if (projectEntity.getTags() != null) {
            projectDto.setTags(projectEntity.getTags().stream().map(TagMapper::mapToDto).collect(Collectors.toSet()));              
        }

        return projectDto;
    }
}
