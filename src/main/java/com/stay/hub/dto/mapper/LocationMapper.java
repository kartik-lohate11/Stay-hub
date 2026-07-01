package com.stay.hub.dto.mapper;

import com.stay.hub.dto.LocationDto;
import com.stay.hub.entity.LocationData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDto toDto(LocationData data);

    LocationData toEntity(LocationDto dto);

    List<LocationDto> toDto(List<LocationData> dataList);

    List<LocationData> toEntity(List<LocationDto> dtoList);
}
