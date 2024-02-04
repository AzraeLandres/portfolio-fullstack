package com.restAPI.portfolio.Service;


import com.restAPI.portfolio.Entity.SkillEntity;
import com.restAPI.portfolio.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public List<SkillEntity> getAllSkills() {
        return skillRepository.findAll();
    }
}
