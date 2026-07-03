package com.stay.hub.dto.mapper;

import com.stay.hub.dto.LocationDto;
import com.stay.hub.dto.UserDto;
import com.stay.hub.entity.LocationData;
import com.stay.hub.entity.UserData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDto toDto(LocationData data);

    LocationData toEntity(LocationDto dto);

    List<LocationDto> toDto(List<LocationData> dataList);

    List<LocationData> toEntity(List<LocationDto> dtoList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(LocationDto dto, @MappingTarget LocationData entity);
}
