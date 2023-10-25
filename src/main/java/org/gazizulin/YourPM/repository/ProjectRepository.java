package org.gazizulin.YourPM.repository;

import org.gazizulin.YourPM.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Timur Gazizulin
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
