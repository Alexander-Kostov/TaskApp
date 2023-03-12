package com.example.taskapp.repository;

import com.example.taskapp.model.dto.TestDTO;
import com.example.taskapp.model.entity.ArchiveTasks;
import com.example.taskapp.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchiveRepository extends JpaRepository<ArchiveTasks, Long> {
    @Query(value = "SELECT new com.example.taskapp.model.dto.TestDTO(a.assignee, COUNT(a.assignee), sum(a.salary)) FROM ArchiveTasks as a " +
            "WHERE month(a.dateOfDelete) = :month " +
            "GROUP BY a.assignee " +
            "ORDER BY count(a.assignee) DESC")
    List<TestDTO> findTop5Employees(Long month);
}
