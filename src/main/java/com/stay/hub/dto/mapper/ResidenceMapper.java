package com.stay.hub.dto.mapper;

import com.stay.hub.dto.ResidenceDto;
import com.stay.hub.entity.ResidenceData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = LocationMapper.class)
public interface ResidenceMapper {
    ResidenceDto toDto(ResidenceData data);

    ResidenceData toEntity(ResidenceDto dto);

    List<ResidenceDto> toDto(List<ResidenceData> data);

    List<ResidenceData> toEntity(List<ResidenceDto> dto);
}
