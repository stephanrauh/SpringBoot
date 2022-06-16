package de.beyondjava.business.projects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Query("""
                    SELECT new de.beyondjava.business.projects.ProjectDto(p.name, p.description)
                    FROM Project p
                    WHERE LOWER(p.name) = LOWER(:projectName)
            """)
    List<ProjectDto> findProjectDtosByProjectName(@Param("projectName") String projectName);
}
