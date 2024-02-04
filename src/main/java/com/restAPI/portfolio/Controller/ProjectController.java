package com.restAPI.portfolio.Controller;


import com.restAPI.portfolio.Mapper.ProjectMapper;
import com.restAPI.portfolio.DTO.ProjectDto;
import com.restAPI.portfolio.Entity.ProjectEntity;

import com.restAPI.portfolio.Service.ProjectService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    
    
    @PostMapping("/add")
    public ProjectEntity postDetails(@RequestBody ProjectEntity project){
        return projectService.saveDetails(project);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<ProjectDto> getProjects(){
        List<ProjectEntity> projects = projectService.getAllProjects();
        return projects.stream().map(ProjectMapper::mapToDto).collect(Collectors.toList());
    }

   

}
    
    


