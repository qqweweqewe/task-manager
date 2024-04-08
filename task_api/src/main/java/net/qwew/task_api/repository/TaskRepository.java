package net.qwew.task_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.qwew.task_api.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    @Transactional
    public void deleteByDone(boolean done);
}
