package com.stay.hub.dto.mapper;

import com.stay.hub.dto.ReviewDto;
import com.stay.hub.dto.UserDto;
import com.stay.hub.entity.ReviewData;
import com.stay.hub.entity.UserData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto toDto(ReviewData data);

    ReviewData toEntity(ReviewDto dto);

    List<ReviewDto> toDto(List<ReviewData> data);

    List<ReviewData> toEntity(List<ReviewDto> dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ReviewDto dto, @MappingTarget ReviewData entity);
}
