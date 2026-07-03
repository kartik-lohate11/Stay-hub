package com.stay.hub.dto.mapper;

import com.stay.hub.dto.ResidenceDto;
import com.stay.hub.entity.ResidenceData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", uses = LocationMapper.class)
public interface ResidenceMapper {
    ResidenceDto toDto(ResidenceData data);

    ResidenceData toEntity(ResidenceDto dto);

    List<ResidenceDto> toDto(List<ResidenceData> data);

    List<ResidenceData> toEntity(List<ResidenceDto> dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ResidenceDto dto, @MappingTarget ResidenceData entity);


}
