package com.example.kanbanserv.services;

import com.example.kanbanserv.domain.Project;
import com.example.kanbanserv.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    // Update operation - tbd

    public Project saveOrUpdateProject(Project project) throws Exception {
        if(projectRepository.existsByProjectIdentifier(project.getProjectIdentifier())) {
            throw new Exception("Project ID already existing: " + project.getId());
        }
        else{
            return projectRepository.save(project);
        }

    }
}
