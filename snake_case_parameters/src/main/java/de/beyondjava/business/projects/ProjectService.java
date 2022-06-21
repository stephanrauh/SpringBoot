package de.beyondjava.business.projects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ProjectService {
    private ProjectMapper projectMapper;

    private ProjectRepository projectRepository;

    public void save(ProjectDto projectDto) {
        val project = projectMapper.dtoToEntity(projectDto);
        projectRepository.save(project);
    }

    public List<ProjectDto> findAll() {
        val projects = projectRepository.findAll();
        return projectMapper.entityToDTO(projects);
    }

    public List<ProjectDto> findProjectsByProjectName(String projectName) {
        return projectRepository.findProjectDtosByProjectName(projectName);
    }

    public ProjectDto findById(long id) {
        val project = projectRepository.findById(id);
        return projectMapper.entityToDTO(project.orElseThrow());
    }
}
