package net.qwew.task_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.qwew.task_api.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
