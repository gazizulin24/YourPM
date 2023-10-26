package org.gazizulin.YourPM.repository;

import org.gazizulin.YourPM.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Timur Gazizulin
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
