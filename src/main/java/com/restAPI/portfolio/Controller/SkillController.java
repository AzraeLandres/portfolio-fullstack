package com.restAPI.portfolio.Controller;


import com.restAPI.portfolio.Entity.SkillEntity;

import com.restAPI.portfolio.Service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;



    @GetMapping("/getSkills")
    public List<SkillEntity> getSkills(){

        return skillService.getAllSkills();
    }
}
