package com.restAPI.portfolio.Mapper;

import com.restAPI.portfolio.DTO.SkillDto;
import com.restAPI.portfolio.Entity.SkillEntity;

public class SkillMapper {
    public static SkillDto mapToDto(SkillEntity skillEntity) {
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skillEntity.getId());
        skillDto.setName(skillEntity.getName());
        return skillDto;
    }
}
