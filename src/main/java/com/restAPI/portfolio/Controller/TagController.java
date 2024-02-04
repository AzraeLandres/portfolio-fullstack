package com.restAPI.portfolio.Controller;


import com.restAPI.portfolio.Entity.TagEntity;
import com.restAPI.portfolio.Repository.TagRepo;
import com.restAPI.portfolio.Service.ProjectService;
import com.restAPI.portfolio.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TagController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    TagRepo tagRepo;
    @Autowired
    private TagService tagService;

    @GetMapping("/getTags")
    public List<TagEntity> getTags(){

        return tagService.getAllTags();
    }

    @GetMapping("/tags/{projectId}")
    public ResponseEntity<List<TagEntity>> getCustom(@PathVariable Integer projectId) {
        return ResponseEntity.ofNullable((tagService.getTagsByProjectId(projectId)));
    }



}
