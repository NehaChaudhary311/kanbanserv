package com.example.kanbanserv.repositories;

import com.example.kanbanserv.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    boolean existsByProjectIdentifier(String id);
}
