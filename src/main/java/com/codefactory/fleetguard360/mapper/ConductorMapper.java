package com.codefactory.fleetguard360.mapper;

import com.codefactory.fleetguard360.controller.DTO.ConductorDTO;
import com.codefactory.fleetguard360.repository.entities.Conductor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ConductorMapper {
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateConductorFromDto(ConductorDTO dto, @MappingTarget Conductor entity);
}