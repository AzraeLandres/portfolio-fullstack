package com.restAPI.portfolio.Mapper;

import com.restAPI.portfolio.DTO.TagDto;
import com.restAPI.portfolio.Entity.TagEntity;

public class TagMapper {
    public static TagDto mapToDto(TagEntity tagEntity) {
        TagDto tagDto = new TagDto();
        tagDto.setId(tagEntity.getId());
        tagDto.setName(tagEntity.getName());
        return tagDto;
    }
}
