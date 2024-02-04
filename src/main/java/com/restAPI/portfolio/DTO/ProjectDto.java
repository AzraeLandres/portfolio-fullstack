package com.restAPI.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDto {

    private Integer id;
    private String name;
    private String about;
    private String link;
    private Set<SkillDto> skills;
    private Set<TagDto> tags;
    
}
