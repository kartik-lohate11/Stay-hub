package com.stay.hub.dto.mapper;

import com.stay.hub.dto.ReviewDto;
import com.stay.hub.entity.ReviewData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto toDto(ReviewData data);

    ReviewData toEntity(ReviewDto dto);

    List<ReviewDto> toDto(List<ReviewData> data);

    List<ReviewData> toEntity(List<ReviewDto> dto);
}
