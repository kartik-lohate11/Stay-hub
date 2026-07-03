package com.stay.hub.dto.mapper;

import com.stay.hub.dto.UserDto;
import com.stay.hub.entity.UserData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ResidenceMapper.class,
                ReviewMapper.class
        })
public interface UserMapper {

    UserDto toDto(UserData data);

    UserData toEntity(UserDto dto);

    List<UserDto> toDto(List<UserData> data);

    List<UserData> toEntity(List<UserDto> dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UserDto dto, @MappingTarget UserData entity);


}
