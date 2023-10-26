package org.gazizulin.YourPM.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.gazizulin.YourPM.entity.Project;
import org.gazizulin.YourPM.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Timur Gazizulin
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
}
