package de.beyondjava.business.projects;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ProjectService {
    private ProjectMapper projectMapper;

    private ProjectRepository projectRepository;

    public void save(ProjectDto projectDto) {
        var project = projectMapper.dtoToEntity(projectDto);
        projectRepository.save(project);
    }

    public List<ProjectDto> findAll() {
        var projects = projectRepository.findAll();
        return projectMapper.entityToDTO(projects);
    }

    public ProjectDto findById(long id) {
        var project = projectRepository.findById(id);
        if (project.isPresent()) {
            return projectMapper.entityToDTO(project.get());
        }
        return null;
    }
}
