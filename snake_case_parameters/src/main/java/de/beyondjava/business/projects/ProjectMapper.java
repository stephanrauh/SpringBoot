package de.beyondjava.business.projects;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDto entityToDTO(Project project);

    List<ProjectDto> entityToDTO(Iterable<Project> project);

    Project dtoToEntity(ProjectDto project);

    List<Project> dtoToEntity(Iterable<ProjectDto> projects);

}